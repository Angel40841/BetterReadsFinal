package com.example.betterreads.service.impl;

import com.example.betterreads.repositories.UserBooksRepository;
import com.example.betterreads.service.UserBooksService;
import org.springframework.stereotype.Service;

@Service
public class UserBooksServiceImpl implements UserBooksService {
    private final UserBooksRepository userBooksRepository;

    public UserBooksServiceImpl(UserBooksRepository userBooksRepository) {
        this.userBooksRepository = userBooksRepository;
    }

}
