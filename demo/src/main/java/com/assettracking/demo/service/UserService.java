package com.assettracking.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("admin", "admin123");
        USERS.put("user", "user123");
    }

    public boolean validate(String username, String password) {
        return USERS.containsKey(username)
                && USERS.get(username).equals(password);
    }
}
