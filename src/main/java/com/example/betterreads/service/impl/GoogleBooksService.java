package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.GoogleBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleBooksService {

    private static final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes";
    private static final String API_KEY = "AIzaSyAjNgkPT7yQTIlu6ItY9EFym7-VGN5JoBM";
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleBooksService.class);

    public GoogleBookResponse searchBooks(String query) {

        RestTemplate restTemplate = new RestTemplate();

        String uri = UriComponentsBuilder.fromHttpUrl(GOOGLE_BOOKS_API_URL)
                .queryParam("q", query)
                .queryParam("key", API_KEY)
                .build()
                .toUriString();

        LOGGER.info("Request URL: {}", uri);

        GoogleBookResponse forObject = restTemplate.getForObject(uri, GoogleBookResponse.class);

        LOGGER.info("Response: {}", forObject);
        return forObject;
    }
}
