package com.example.betterreads.service.impl;

import com.example.betterreads.config.BookModuleApiConfig;
import com.example.betterreads.model.dto.AddBookDTO;
import com.example.betterreads.model.entites.Book;
import com.example.betterreads.repositories.BookRepository;
import com.example.betterreads.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final RestClient restClient;
    private final BookModuleApiConfig bookModuleApiConfig;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, @Qualifier("googleSearchBooks") RestClient restClient, BookModuleApiConfig bookModuleApiConfig) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.restClient = restClient;
        this.bookModuleApiConfig = bookModuleApiConfig;
    }

    @Override
    public void addBook(AddBookDTO book) {
        bookRepository.save(map(book));
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public AddBookDTO searchBooks(String query) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        return restClient
                .get()
                .uri(bookModuleApiConfig.getBaseUrl())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(AddBookDTO.class);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    private Book map(AddBookDTO bookData) {

        Book map = modelMapper.map(bookData, Book.class);
        map.setAuthor(bookData.getAuthor());
        map.setTitle(bookData.getTitle());
        map.setPublishedDate(bookData.getPublishedDate());
        map.setDescription(bookData.getDescription());
        map.setThumbnail(bookData.getThumbnail());
        return map;
    }
}
