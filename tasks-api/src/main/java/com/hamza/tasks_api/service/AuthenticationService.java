package com.hamza.tasks_api.service;

import com.hamza.tasks_api.dto.LoginRequest;
import com.hamza.tasks_api.dto.RegisterRequest;
import com.hamza.tasks_api.entity.User;
import com.hamza.tasks_api.repository.UserRepository;
import com.hamza.tasks_api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());

        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        return jwtUtil.generateToken(request.username());
    }
}
