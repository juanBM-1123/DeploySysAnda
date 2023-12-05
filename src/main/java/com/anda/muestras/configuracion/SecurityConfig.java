package com.anda.muestras.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.anda.muestras.jwt.JwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authProvider;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.cors(cors -> cors.configurationSource(request -> {
			        CorsConfiguration configuration = new CorsConfiguration();
			        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
			        configuration.setAllowedMethods(Arrays.asList("*"));
			        configuration.setAllowedHeaders(Arrays.asList("*"));
			        return configuration;
			    }))
				.csrf(csrf->csrf.disable())
				.logout(logout -> logout
                        .logoutUrl("/auth/logout")  // Endpoint de logout
                        .logoutSuccessUrl("/auth/api/logout/success")  // URL de éxito de logout
                        .invalidateHttpSession(true)
                )
				.authorizeHttpRequests(
						authRequest->
						authRequest
						.requestMatchers(HttpMethod.GET).permitAll()
					    .requestMatchers(HttpMethod.OPTIONS).permitAll()
					    .requestMatchers(HttpMethod.POST).permitAll()
						.requestMatchers("/auth/**").permitAll()
						.anyRequest().authenticated()
						)
				//.formLogin(withDefaults())
				.sessionManagement(sessionManager -> 
				sessionManager
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
 
}
