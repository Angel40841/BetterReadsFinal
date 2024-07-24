package com.example.betterreads.model.entites.user;

import com.example.betterreads.model.entites.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    public UserRoles getRole() {
        return roles;
    }
}
