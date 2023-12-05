package com.anda.muestras.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.Roles;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.jwt.JwtService;
import com.anda.muestras.model.Roles;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final CustomUserService customUserService;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthResponse login(LoginRequest request) {
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
	        CustomUser user = customUserService.findByUsername(request.getUsername()).orElseThrow();
	        String token=jwtService.getToken(user);
	        return AuthResponse.builder()
	            .token(token)
	            .roles(user.getAuthorities())
	            .build();
	}
	
	public AuthResponse register(RegisterRequest request) {
		CustomUser user  = CustomUser.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode( request.getPassword()))
				.apellidos(request.getApellidos())
				.nombres(request.getNombres())
				.rol(this.obtenerRol(request.getRol()))
				.build();
		this.customUserService.save(user);
		//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		return AuthResponse.builder()
				.token(this.jwtService.getToken(user))
				.roles(user.getAuthorities())
				.build();
	}
	
	
	public Roles obtenerRol (String rol) {
		Roles tempRole = null;
		for(Roles r: Roles.values()) {
			if(r.name().equals(rol)) {
				tempRole = r;
				break;
			}
		}
		
		return tempRole;
		
	}
}
