package com.example.loginfrom.security;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import static com.example.loginfrom.security.Permissions.*;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(Set.of(READ,WRITE,DELETE)),
    STUDENT(Set.of(READ));
    private  final  Set<Permissions> permissions;

}