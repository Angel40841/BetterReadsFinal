package com.example.betterreads.service.impl;

import com.example.betterreads.model.entites.user.BetterReadsUserDetails;
import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.model.entites.user.UserRoleEntity;
import com.example.betterreads.model.entites.user.UserRoles;
import com.example.betterreads.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BetterReadsUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BetterReadsUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username)
                .map(BetterReadsUserDetailsService::map)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username: " + username + " not found!"));
    }

    private static UserDetails map(User user) {

        return new BetterReadsUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(UserRoleEntity::getRole).map(BetterReadsUserDetailsService::mapRoles).toList(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private static GrantedAuthority mapRoles(UserRoles role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }

}
