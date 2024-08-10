package com.example.betterReads.book_module.controller;

import com.example.betterReads.book_module.model.dto.GoogleBookResponseDTO;
import com.example.betterReads.book_module.service.impl.GoogleBooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleBooksController {

    private final GoogleBooksService googleBooksService;

    public GoogleBooksController(GoogleBooksService googleBooksService) {
        this.googleBooksService = googleBooksService;
    }

    @GetMapping("/api/books/search")
    public GoogleBookResponseDTO searchBooks(@RequestParam String query) {
        return googleBooksService.searchBooks(query);
    }
}
