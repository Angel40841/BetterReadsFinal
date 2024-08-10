package com.example.betterreads.controller;

import com.example.betterreads.model.entites.Book;
import com.example.betterreads.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Book> results = null;
        return "search";
    }
    @GetMapping("/books/all")
    public String allBooks(){
        bookService.getAllBooks();
        return "search";
    }
}
