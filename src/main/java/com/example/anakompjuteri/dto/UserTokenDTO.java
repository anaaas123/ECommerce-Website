package com.example.anakompjuteri.dto;

import com.example.anakompjuteri.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenDTO {
    private User user;
    private Instant iat;
    private Instant exp;
}
