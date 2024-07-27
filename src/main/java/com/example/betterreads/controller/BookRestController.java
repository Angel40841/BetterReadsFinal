package com.example.betterreads.controller;

import com.example.betterreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/search")
    public ResponseEntity<String> searchBooks(@RequestParam String query) {
        String response = bookService.searchBooks(query);
        return ResponseEntity.ok(response);
    }
}
