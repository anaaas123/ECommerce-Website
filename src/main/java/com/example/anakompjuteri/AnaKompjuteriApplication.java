package com.example.anakompjuteri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnaKompjuteriApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnaKompjuteriApplication.class, args);
    }

}
