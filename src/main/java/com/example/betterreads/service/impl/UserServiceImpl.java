package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.model.entites.user.UserRoles;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.repositories.UserRepository;
import com.example.betterreads.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;
    private final BookRepository bookRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder encoder,
            BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.encoder = encoder;
        this.bookRepository = bookRepository;
    }

    @Override
    public void register(UserRegisterDTO registerData) {
        userRepository.save(map(registerData));
    }

    @Override
    public void addBook(Book book) {
    }

    public User map(UserRegisterDTO registerData) {
        User mappedUser = modelMapper.map(registerData, User.class);
        mappedUser.setRegisteredOn(Instant.now());
        mappedUser.setPassword(encoder.encode(registerData.getPassword()));

        if (userRepository.count() == 0) {
            mappedUser.setAdmin(true);
            mappedUser.setRole(UserRoles.ADMIN);
        } else {
            mappedUser.setRole(UserRoles.USER);
        }
        return mappedUser;
    }
}
