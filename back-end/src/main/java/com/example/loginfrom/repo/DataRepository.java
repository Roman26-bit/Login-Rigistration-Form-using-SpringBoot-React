package com.example.loginfrom.repo;

import com.example.loginfrom.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DataRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
}
