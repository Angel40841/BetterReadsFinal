package com.example.betterreads.controller;

import com.example.betterreads.model.entites.Book;
import com.example.betterreads.model.entites.UserBooks;
import com.example.betterreads.model.entites.user.User;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.repositories.UserBooksRepository;
import com.example.betterreads.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserBooksController {

    private final BookRepository bookRepository;
    private final UserBooksRepository userBookRepository;
    private final UserRepository userRepository;

    public UserBooksController(BookRepository bookRepository, UserBooksRepository userBookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userBookRepository = userBookRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/book/{id}")
    public String getBookDetails(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("userBooks", new UserBooks());
        java.lang.String username = getCurrentUsername();
        userRepository.findByUsername(username).ifPresent(user -> model.addAttribute("loginId", user.getId()));
        return "book-details";
    }
    @PostMapping("/addUserBook")
    public String addUserBook(@ModelAttribute UserBooks userBook, @RequestParam Long bookId, @RequestParam Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        userBook.setBook(book);
        userBook.setUser(user);
        userBook.setStartedDate(LocalDate.now());
        userBookRepository.save(userBook);
        return "redirect:/books/" + bookId;
    }

    private java.lang.String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}


