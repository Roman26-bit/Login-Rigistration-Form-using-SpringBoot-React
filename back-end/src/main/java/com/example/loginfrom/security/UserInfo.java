package com.example.loginfrom.security;

import com.example.loginfrom.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


@AllArgsConstructor
@Data
public class UserInfo implements UserDetails {

    Users users;
    @Override
    public @Nullable String getPassword() {
        return users.getPassword();
    }

    @Override
    public  @NonNull String getUsername() {
        return users.getEmail();
    }

    @Override
    public @NonNull Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}
}

