package com.example.loginfrom.security;
import com.example.loginfrom.entity.Users;
import com.example.loginfrom.exception.UserNotFoundException;
import com.example.loginfrom.repo.DataRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService implements UserDetailsService {

    DataRepository repo;
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Users users = repo.findByEmail(username).orElseThrow(()-> new UserNotFoundException("User Not Found"));
        return new UserInfo(users);
    }
}