package com.example.betterReads.book_module.controller;

import com.example.betterReads.book_module.model.dto.GoogleBookResponse;
import com.example.betterReads.book_module.service.GoogleBooksService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoogleBooksController {

    private final GoogleBooksService googleBooksService;

    public GoogleBooksController(GoogleBooksService googleBooksService) {
        this.googleBooksService = googleBooksService;
    }
    @GetMapping("/search")
    public GoogleBookResponse searchBooks(@RequestParam String query) {
        return googleBooksService.searchBooks(query);
    }
   
}
