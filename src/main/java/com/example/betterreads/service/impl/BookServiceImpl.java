package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.model.dto.UserRegisterDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.Instant;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBook(AddBookDTO book) {
        bookRepository.save(map(book));
    }

    private Book map(AddBookDTO bookData) {
        Book mappedBook = modelMapper.map(bookData, Book.class);
        return mappedBook;
    }
}
