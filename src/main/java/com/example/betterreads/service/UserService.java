package com.example.betterreads.service;

import com.example.betterreads.model.dto.UserRegisterDTO;

public interface UserService {
    void register(UserRegisterDTO registerData);
    Long userId(Long id);
}
