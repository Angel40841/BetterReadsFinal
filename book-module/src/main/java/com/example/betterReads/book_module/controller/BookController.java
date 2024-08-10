package com.example.betterReads.book_module.controller;

import com.example.betterReads.book_module.model.dto.GoogleBookResponseDTO;
import com.example.betterReads.book_module.service.BookService;
import com.example.betterReads.book_module.service.impl.GoogleBooksService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final BookService bookService;
    private final GoogleBooksService googleBooksService;

    public BookController(BookService bookService, GoogleBooksService googleBooksService) {
        this.bookService = bookService;
        this.googleBooksService = googleBooksService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String query) {
        return bookService.searchBooks(query);
    }

}
