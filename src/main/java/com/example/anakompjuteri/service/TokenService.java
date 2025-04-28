package com.example.anakompjuteri.service;


import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateJwt(Authentication authentication);
}