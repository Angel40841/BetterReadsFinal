package com.example.betterReads.book_module.service.impl;

import com.example.betterReads.book_module.model.dto.GoogleBookResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleBooksService {

    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";
    private static final String API_KEY = "AIzaSyAjNgkPT7yQTIlu6ItY9EFym7-VGN5JoBM";

    public GoogleBookResponseDTO searchBooks(String query) {

        RestTemplate restTemplate = new RestTemplate();

        String uri = UriComponentsBuilder.fromHttpUrl(GOOGLE_BOOKS_API_URL)
                .queryParam("q", query)
                .queryParam("key", API_KEY)
                .build()
                .toUriString();

        return restTemplate.getForObject(uri, GoogleBookResponseDTO.class);
    }
}
