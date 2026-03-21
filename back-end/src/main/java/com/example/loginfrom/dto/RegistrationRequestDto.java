package com.example.loginfrom.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegistrationRequestDto {
    @NotBlank(message = "Name is a required Field")
    private String name;
    @NotNull(message = "Password is a required field")
    @Length(min = 4 , max = 10)
    private String password;
    @NotBlank(message = "email is a required Field")
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank(message = "phoneNumber is a required Field")
    private String phoneNumber;
    @NotNull
    private String role;
}
