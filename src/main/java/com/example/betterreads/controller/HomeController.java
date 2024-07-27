package com.example.betterreads.controller;

import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final PostService postService;

    public HomeController(BookService bookService, PostService postService) {
        this.bookService = bookService;
        this.postService = postService;
    }

    @ModelAttribute("posts")
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }

    @ModelAttribute("books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
