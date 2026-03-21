package com.example.loginfrom.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotNull(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull(message = "Password is required")
    private String password;
}
