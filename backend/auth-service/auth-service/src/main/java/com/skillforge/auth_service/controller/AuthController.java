package com.skillforge.auth_service.controller;

import com.skillforge.auth_service.dto.AuthResponse;
import com.skillforge.auth_service.dto.LoginRequest;
import com.skillforge.auth_service.dto.RegistrationRequest;
import com.skillforge.auth_service.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

@Tag(name = "Authentication Controller",description = "Handles registration and login")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegistrationRequest request){
        AuthResponse response=authService.register(request);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Login existing user")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse response=authService.login(request);
        return ResponseEntity.ok(response);
    }
}
