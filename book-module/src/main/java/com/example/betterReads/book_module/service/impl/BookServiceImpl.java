package com.example.betterReads.book_module.service.impl;

import com.example.betterReads.book_module.model.dto.AddBookDTO;
import com.example.betterReads.book_module.model.entity.Book;
import com.example.betterReads.book_module.repository.BookRepository;
import com.example.betterReads.book_module.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final RestClient restClient;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, RestClient restClient) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.restClient = restClient;
    }

    @Override
    public void addBook(AddBookDTO book) {
        bookRepository.save(map(book));
    }

    @Override
    public void removeBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public String searchBooks(String query) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    private Book map(AddBookDTO bookData) {
        Book mappedBook = modelMapper.map(bookData, Book.class);
        mappedBook.setThumbnail(bookData.thumbnail());

        return mappedBook;
    }
}
