package com.anda.muestras.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anda.muestras.model.Roles;

import com.anda.muestras.model.CustomUser;
import com.anda.muestras.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	private final CustomUserService customUserService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(this.authService.login(loginRequest));
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

		return ResponseEntity.ok(this.authService.register(request));
	}

	   @PostMapping("/logout")
	    private ResponseEntity<String> cerrarSession(){
	    	//SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	    	return ResponseEntity.ok("Cerro sesion correctamente");    
	    	
	   }
	    
	    @GetMapping("/api/logout/success")
	    public ResponseEntity<String> logoutSuccess() {
	        return ResponseEntity.ok("Logout exitoso");
	    }
}
