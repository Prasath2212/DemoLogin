package com.assettracking.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Static users (NO DB)
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password("admin123")
                    .roles("ADMIN")
                    .build();
        }

        if ("user".equals(username)) {
            return User.withUsername("user")
                    .password("user123")
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
