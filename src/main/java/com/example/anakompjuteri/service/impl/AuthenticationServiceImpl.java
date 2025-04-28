package com.example.anakompjuteri.service.impl;

import com.example.anakompjuteri.model.User;
import com.example.anakompjuteri.repository.UserRepository;
import com.example.anakompjuteri.service.AuthenticationService;
import com.example.anakompjuteri.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public User register(String username, String firstname, String lastname, String password, String email) {
        if(
                username == null ||
                        password == null ||
                        firstname == null ||
                        lastname == null ||
                        email == null
        )
            throw new RuntimeException("Empty data sent");
        Optional<User> lookupByUsername = userRepository.findByUsername(username);
        Optional<User> lookupByEmail = userRepository.findByEmail(email);
        if(lookupByUsername.isPresent() || lookupByEmail.isPresent())
            throw new RuntimeException("User already exists");
        return userRepository.save(new User(username, firstname, lastname,passwordEncoder.encode(password),email));
    }

    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return tokenService.generateJwt(auth);
        }
        throw new RuntimeException("Invalid username or password");
    }
}