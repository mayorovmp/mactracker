package com.mactracker.service;

import com.mactracker.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByToken(String token);

    void register(String login, String pass);

    String login(String email, String pass);
}
