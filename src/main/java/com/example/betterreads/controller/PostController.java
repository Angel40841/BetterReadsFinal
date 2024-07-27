package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute("postData")
    public AddPostDTO postData() {
        return new AddPostDTO();
    }

    @GetMapping("/post")
    public String post(){
        return "home";
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable(value = "id") Model model, Long id) {
        Optional<PostEntity> byId = postService.findById(id);
        model.addAttribute("posts", byId);
        return "home";
    }


    @PostMapping("/post/add")
    public String doPost(AddPostDTO postData, Model model) {
        model.addAttribute("postData", postData);
        postService.addPost(postData);
        return "redirect:/home";
    }


}
