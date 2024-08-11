package com.example.betterreads.controller;

import com.example.betterreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    public BookRestController(BookService bookService) {
    }

}
