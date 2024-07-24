package com.example.betterreads.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 3, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String lastName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(@NotBlank @Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public void setFirstName(@NotBlank @Size(min = 3, max = 20) String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotBlank @Size(min = 3, max = 20) String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(@NotBlank @Size(min = 3, max = 20) String password) {
        this.password = password;
    }
}
