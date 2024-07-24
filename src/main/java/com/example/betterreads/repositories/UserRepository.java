package com.example.betterreads.repositories;

import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.service.impl.BetterReadsUserDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
