package com.example.betterreads.controller;

import com.example.betterreads.model.dto.UserLoginDTO;
import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO registerData() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginData")
    public UserLoginDTO loginData() {
        return new UserLoginDTO();
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserRegisterDTO registerData) {
        userService.register(registerData);
        return "redirect:/login";
    }
    @GetMapping("/userId")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

}
