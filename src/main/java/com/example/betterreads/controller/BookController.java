package com.example.betterreads.controller;

import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.service.BookService;
import com.example.betterreads.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @ModelAttribute("bookData")
    public AddBookDTO bookData() {
        return new AddBookDTO();
    }

    @GetMapping("/add-book")
    public String addBook() {
        return "add-book";
    }

    @PostMapping("/add-book")
    public String doAddBook(AddBookDTO bookData) {
        bookService.addBook(bookData);
        return "redirect:/home";
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleObjectNotFound(ObjectNotFoundException onfe){
        ModelAndView mav = new ModelAndView("book-not-found");
        mav.addObject("bookId", onfe.getId());

        return mav;
    }

    @GetMapping("/books/{id}")
    public String getBookDetails(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "book-details";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        return "redirect:/home";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.removeBook(id);
        return "redirect:/home";
    }
}
