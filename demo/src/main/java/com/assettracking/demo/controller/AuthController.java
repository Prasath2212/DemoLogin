package com.assettracking.demo.controller;

import com.assettracking.demo.dto.LoginRequest;
import com.assettracking.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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

        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/logout")
    public String logout() {
        return "Logout successful";
    }
}
