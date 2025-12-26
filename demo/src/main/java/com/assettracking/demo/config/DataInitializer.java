package com.assettracking.demo.config;

import com.assettracking.demo.entity.UserEntity;
import com.assettracking.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Always ensure the 'admin' user exists with the correct password
        UserEntity user = userRepository.findByUsername("admin").orElse(new UserEntity());
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("password123"));  // Force correct hash
        userRepository.save(user);
        System.out.println("User 'admin' ensured with correct password hash.");
    }
}