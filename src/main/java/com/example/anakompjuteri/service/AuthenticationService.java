package com.example.anakompjuteri.service;

import com.example.anakompjuteri.model.User;

public interface AuthenticationService {
    User register(String username, String firstname, String lastname, String password, String email);
    String login(String username, String password);
}
