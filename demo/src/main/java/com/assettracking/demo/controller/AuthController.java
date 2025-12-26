package com.assettracking.demo.controller;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assettracking.demo.config.JwtUtil;
import com.assettracking.demo.dto.LoginRequest;
import com.assettracking.demo.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        boolean valid = userService.validate(
                request.getUsername(),
                request.getPassword()
        );

        if (!valid) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Nothing to invalidate on server (JWT is stateless)
        return ResponseEntity.ok("Logout successful");
    }

}
