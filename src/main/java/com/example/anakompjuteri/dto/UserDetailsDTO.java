package com.example.anakompjuteri.dto;

import com.example.anakompjuteri.model.Role;
import com.example.anakompjuteri.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
    public String username;
    public String firstname;
    public String lastname;
    public String email;
    public Set<Role> roles;

    public UserDetailsDTO(User user){
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.roles = user.getAuthorities();
    }
}