package com.example.betterreads.model.entites.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class BetterReadsUserDetails extends User {
private final Long id;
    private final String firstName;
    private final String lastName;

    public BetterReadsUserDetails(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Long id,
            String firstName,
            String lastName
    ) {
        super(username, password, authorities);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        if (firstName != null) {
            fullName.append(firstName);
        }
        if (lastName != null) {
            if (!fullName.isEmpty()) {
                fullName.append(" ");
            }
            fullName.append(lastName);
        }

        return fullName.toString();
    }
}