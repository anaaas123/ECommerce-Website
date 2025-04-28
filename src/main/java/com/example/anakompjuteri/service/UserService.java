package com.example.anakompjuteri.service;

import com.example.anakompjuteri.model.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
}
