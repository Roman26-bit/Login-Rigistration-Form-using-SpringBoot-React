package com.example.loginfrom.entity;

import com.example.loginfrom.security.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
}
