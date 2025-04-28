package com.example.anakompjuteri.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    public String username;
    public String firstname;
    public String lastname;
    public String email;
    public String password;
}
