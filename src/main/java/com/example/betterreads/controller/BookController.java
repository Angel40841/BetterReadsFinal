package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }
    @ModelAttribute("bookData")
    public AddBookDTO bookData(){
        return new AddBookDTO();
    }
    @GetMapping("/add-book")
    public String addBook(){
        return "add-book";
    }
    @PostMapping("/add-book")
    public String doAddBook(AddBookDTO bookData){
        bookService.addBook(bookData);

        return "redirect:/home";
    }
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id, Model model){
        bookRepository.deleteById(id);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/home";
    }

}
