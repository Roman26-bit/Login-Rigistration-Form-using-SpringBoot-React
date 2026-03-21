package com.example.loginfrom.controller;


import com.example.loginfrom.dto.LoginRequestDto;
import com.example.loginfrom.dto.LoginResponseDto;
import com.example.loginfrom.dto.RegistrationRequestDto;
import com.example.loginfrom.dto.RegistrationResponseDto;
import com.example.loginfrom.security.TokenInfo;
import com.example.loginfrom.security.UserInfo;
import com.example.loginfrom.service.LoginFormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/form")
public class loginRegistrationController {
    LoginFormService service;
    TokenInfo tokenInfo;
    AuthenticationManager authenticationManager;

    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponseDto> registration(@Valid @RequestBody RegistrationRequestDto requestDto){
        return new ResponseEntity<>(service.registration(requestDto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        String token = tokenInfo.generateToken(userInfo.getUsername(),userInfo.getUsers().getRole());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
