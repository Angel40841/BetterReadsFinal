package com.example.betterReads.book_module.service;

import com.example.betterReads.book_module.model.dto.AddBookDTO;
import com.example.betterReads.book_module.model.entity.Book;
import org.springframework.web.client.RestClient;

import java.util.List;

public interface BookService {
    void addBook(AddBookDTO book);

    void removeBook(String id);

    String searchBooks(String query);

    List<Book> getAllBooks();
}
