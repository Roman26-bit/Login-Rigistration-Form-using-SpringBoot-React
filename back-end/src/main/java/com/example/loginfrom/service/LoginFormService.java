package com.example.loginfrom.service;

import com.example.loginfrom.dto.RegistrationRequestDto;
import com.example.loginfrom.dto.RegistrationResponseDto;
import com.example.loginfrom.entity.Users;
import com.example.loginfrom.exception.EmailAlreadyExistException;
import com.example.loginfrom.mapper.MapperFile;
import com.example.loginfrom.repo.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginFormService {
    DataRepository repo;
    MapperFile mapper;
    PasswordEncoder passwordEncoder;

    public RegistrationResponseDto registration(RegistrationRequestDto request){
        Users user = mapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (!repo.existsByEmail(user.getEmail())){
            repo.save(user);
            System.out.println(repo.existsByEmail(user.getEmail()));
            return new RegistrationResponseDto( request.getName());
        }
        else {
            System.out.println(repo.existsByEmail(user.getEmail()));
            throw new EmailAlreadyExistException("Email is already registered");
        }
    }
}
