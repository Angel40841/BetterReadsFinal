package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final PostService postService;

    public HomeController(BookService bookService, PostService postService) {
        this.bookService = bookService;
        this.postService = postService;
    }

    @ModelAttribute("postData")
    public AddPostDTO postData() {
        return new AddPostDTO();
    }

    @ModelAttribute("books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/post/add")
    public String getPost(Model model) {
        List<AddPostDTO> allPosts = postService.getAll();
        model.addAttribute("viewAllPost", allPosts);
        return "home";
    }

    @PostMapping("/post/add")
    public String doPost(AddPostDTO postData, Model model) {
        model.addAttribute("postData", postData);
        postService.addPost(postData);
        return "home";
    }


}
