package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.model.entites.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void addBook(AddBookDTO book);
    void removeBook(Long id);
    AddBookDTO searchBooks(String query);
Optional<Book> findById(Long bookId);
    List<Book> getAllBooks();
}
