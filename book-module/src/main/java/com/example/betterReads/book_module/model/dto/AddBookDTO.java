package com.example.betterReads.book_module.model.dto;

public record AddBookDTO(String id,
                         String authors,
                         String publishedDate,
                         String description,
                         Integer pageCount,
                         String thumbnail) {
}
