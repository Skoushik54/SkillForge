package com.skillforge.auth_service.service;

import com.skillforge.auth_service.dto.AuthResponse;
import com.skillforge.auth_service.dto.LoginRequest;
import com.skillforge.auth_service.dto.RegistrationRequest;
import com.skillforge.auth_service.entity.Role;
import com.skillforge.auth_service.entity.User;
import com.skillforge.auth_service.repository.UserRepository;
import com.skillforge.auth_service.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegistrationRequest registrationRequest){
        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()){
            return new AuthResponse(null,"Email already registered");
        }
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setRole(Role.valueOf(registrationRequest.getRole().toString().toUpperCase()));
        user.setEnabled(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setVerifiedAt(LocalDateTime.now());

        userRepository.save(user);
        String token= jwtUtil.generateToken(user.getEmail(),user.getRole().toString());
        return new AuthResponse(token,"User registered successfully");
    }
    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("User not found"));
        String token = jwtUtil.generateToken(user.getEmail(),user.getRole().toString());
        return new AuthResponse(token,"Login successful");
    }
}
