package com.example.loginfrom.dto;

import lombok.Data;

@Data
public class RegistrationResponseDto {
    private String name;
    private String message;

    public RegistrationResponseDto(String name) {
        this.name = name;
        this.message = "You are successfully registered. Thank you!";
    }
}
