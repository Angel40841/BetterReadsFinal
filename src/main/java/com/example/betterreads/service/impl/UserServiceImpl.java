package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.model.entites.user.UserRoles;
import com.example.betterreads.repositories.UserRepository;
import com.example.betterreads.service.UserService;
import com.example.betterreads.service.exception.DatabaseException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.encoder = encoder;

    }

    @Override
    @Transactional
    public void register(UserRegisterDTO registerData) {
        try {
            userRepository.save(map(registerData));
        } catch (Exception e) {
            throw new DatabaseException("An error occurred while saving user to the database");
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
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
