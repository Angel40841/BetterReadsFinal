package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddBookDTO;

import com.example.betterreads.model.entites.Book;

import java.util.List;

public interface BookService {
    void addBook(AddBookDTO book);
    void removeBook(Long id);

    String searchBooks(String query);

    List<Book> getAllBooks();
}
