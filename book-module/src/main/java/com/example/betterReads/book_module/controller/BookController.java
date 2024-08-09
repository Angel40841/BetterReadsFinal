package com.example.betterReads.book_module.controller;

import com.example.betterReads.book_module.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }
}
