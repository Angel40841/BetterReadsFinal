package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddBookDTO;

public interface BookService {
    void addBook(AddBookDTO book);
    void removeBook(Long id);

    String searchBooks(String query);
}
