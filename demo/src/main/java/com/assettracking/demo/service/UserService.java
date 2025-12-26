package com.assettracking.demo.service;

import com.assettracking.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	/*
	 * public boolean validate(String username, String password) { return
	 * userRepository.findByUsername(username) .map(user ->
	 * passwordEncoder.matches(password, user.getPassword())) .orElse(false); //
	 * Return false if user not found }
	 */
    
    public boolean validate(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    boolean match = passwordEncoder.matches(password, user.getPassword());
                    System.out.println("DEBUG: Username=" + username + ", InputPass=" + password + ", DBHash=" + user.getPassword() + ", Match=" + match);
                    return match;
                })
                .orElse(false);
    }
}