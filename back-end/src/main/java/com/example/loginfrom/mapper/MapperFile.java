package com.example.loginfrom.mapper;

import com.example.loginfrom.dto.RegistrationRequestDto;
import com.example.loginfrom.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperFile {
    Users toEntity(RegistrationRequestDto dto);

}
