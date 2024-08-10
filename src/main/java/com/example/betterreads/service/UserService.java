package com.example.betterreads.service;

import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.model.entites.Book;

public interface UserService {
    void register(UserRegisterDTO registerData);

    void delete(Long id);


}
