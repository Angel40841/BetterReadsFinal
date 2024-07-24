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
    private String fullName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public @NotBlank @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public @NotBlank @Size(min = 3, max = 20) String getFullName() {
        return fullName;
    }

    public @NotBlank @Size(min = 3, max = 20) String getPassword() {
        return password;
    }

    public @NotBlank @Size(min = 3, max = 20) String getConfirmPassword() {
        return confirmPassword;
    }
}
