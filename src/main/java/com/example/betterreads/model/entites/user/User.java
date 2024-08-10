package com.example.betterreads.model.entites.user;

import com.example.betterreads.model.entites.BaseEntity;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.model.entites.UserBooks;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoles role;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false,name = "last_name")
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, name = "registered_on")
    private Instant registeredOn;
    @Column(nullable = false, unique = true, name = "is_admin")
    private boolean isAdmin;
    @OneToMany
    private List<Book> userBooks;
    @OneToMany(mappedBy = "user")
    private Set<PostEntity> posts;
    @OneToMany
    private List<UserBooks> userBooksDetails;

    public User() {
        this.userBooks = new ArrayList<>();
        this.userBooksDetails = new ArrayList<>();
        this.posts = new HashSet<>();
    }

    public UserRoles getRole() {
        return role;
    }

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )


    private List<UserRoleEntity> roles = new ArrayList<>();

    public java.lang.String getUsername() {
        return username;
    }

    public Instant getRegisteredOn() {
        return registeredOn;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public java.lang.String getEmail() {
        return email;
    }


    public java.lang.String getPassword() {
        return password;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public void setRegisteredOn(Instant registeredOn) {
        this.registeredOn = registeredOn;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public User setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }
}
