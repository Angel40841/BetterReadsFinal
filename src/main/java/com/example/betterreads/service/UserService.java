package com.example.betterreads.service;

import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.model.entites.user.User;

import java.util.Optional;

public interface UserService {
    void register(UserRegisterDTO registerData);
    void deleteUser(Long id);
    String getCurrentUsername();
    Optional<User> findById(Long userId);
    Optional<User> findByUsername(String username);
}
