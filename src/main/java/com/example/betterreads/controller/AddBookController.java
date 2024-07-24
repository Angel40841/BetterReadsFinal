package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.service.BookService;
import jakarta.persistence.MappedSuperclass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBookController {
    private final BookService bookService;

    public AddBookController(BookService bookService) {
        this.bookService = bookService;
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
}
