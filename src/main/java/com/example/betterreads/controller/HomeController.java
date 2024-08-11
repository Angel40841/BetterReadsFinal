package com.example.betterreads.controller;


import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.Comment;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.repositories.UserRepository;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.CommentService;
import com.example.betterreads.service.PostService;
import com.example.betterreads.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final PostService postService;
    private final BookRepository bookRepository;

    public HomeController(BookService bookService, CommentService commentService, UserService userService, UserRepository userRepository, PostService postService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.commentService = commentService;
        this.userRepository = userRepository;
        this.postService = postService;
        this.bookRepository = bookRepository;
    }

    @ModelAttribute("books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
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
    @PostMapping("/addComment")
    public String addComment(@RequestParam String content, @RequestParam Long postId, @RequestParam Long userId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(userRepository.findById(userId).orElseThrow());
        comment.setPost(postService.getAllPosts().stream().filter(post -> post.getId().equals(postId)).findFirst().orElseThrow());
        commentService.addComment(comment);
        return "redirect:/home";
    }

}
