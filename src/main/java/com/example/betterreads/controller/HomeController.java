package com.example.betterreads.controller;


import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.repositories.UserRepository;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.CommentService;
import com.example.betterreads.service.PostService;
import com.example.betterreads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final PostService postService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public HomeController(CommentService commentService,
                          UserRepository userRepository,
                          PostService postService,
                          BookService bookService,
                          UserService userService) {
        this.commentService = commentService;
        this.userRepository = userRepository;
        this.postService = postService;
        this.bookService = bookService;
        this.userService = userService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("books", bookService.getAllBooks());
        String username = userService.getCurrentUsername();
        userService.findByUsername(username).ifPresent(user -> model.addAttribute("loginId", user.getId()));
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/all-books")
    public String allBooks(Model model) {
        return "all-books";
    }

    @GetMapping("/all-users")
    public String allUsers(Model model) {
        return "all-users";
    }






}
