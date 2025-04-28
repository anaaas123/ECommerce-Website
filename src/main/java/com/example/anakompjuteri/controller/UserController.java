package com.example.anakompjuteri.controller;

import com.example.anakompjuteri.dto.UserDetailsDTO;
import com.example.anakompjuteri.dto.UserLoginDTO;
import com.example.anakompjuteri.dto.UserRegisterDTO;
import com.example.anakompjuteri.model.User;
import com.example.anakompjuteri.service.AuthenticationService;
import com.example.anakompjuteri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserRegisterDTO user) {
        try {
            User registeredUser = authService.register(user.username, user.firstname, user.lastname, user.password, user.email);
            return ResponseEntity.ok(new UserDetailsDTO((registeredUser)));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginDTO userDTO, HttpServletResponse response) {
        try {
            String token = authService.login(userDTO.username, userDTO.password);
//            Cookie cookie = new Cookie("JWT", token);
//            cookie.setMaxAge(3600); // Expires in 1 hour
//            cookie.setSecure(true);
//            response.addCookie(cookie);
            return ResponseEntity.ok().body(token);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDetailsDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDetailsDTO> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }
}