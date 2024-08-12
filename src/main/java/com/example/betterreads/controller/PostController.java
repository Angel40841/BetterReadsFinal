package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.PostService;
import com.example.betterreads.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private final BookService bookService;

    public PostController(PostService postService, UserService userService, BookService bookService) {
        this.postService = postService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @ModelAttribute("postData")
    public AddPostDTO postData() {
        return new AddPostDTO();
    }

    @GetMapping("/posts")
    public String post() {
        return "home";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable(value = "id") Model model, Long id) {
        Optional<PostEntity> byId = postService.findById(id);
        model.addAttribute("postById", byId);
        return "home";
    }


    @PostMapping("/posts/add")
    public String addPost(@RequestParam String content, @RequestParam Long bookId, @RequestParam Long userId) {

        PostEntity post = new PostEntity();
        post.setPostContent(content);
        post.setUser(userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID")));
        post.setBook(bookService.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID")));
        postService.addPost(post);
        return "redirect:/home";
    }

}
