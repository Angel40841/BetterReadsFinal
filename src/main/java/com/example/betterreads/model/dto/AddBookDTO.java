package com.example.betterreads.model.dto;

import jakarta.validation.constraints.NotBlank;

public class AddBookDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String authors;
    @NotBlank
    private Integer publishedDate;

    private String description;
    private String thumbnail;

    public AddBookDTO() {
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String author) {
        this.authors = authors;
    }

    public Integer getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Integer publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }
}
