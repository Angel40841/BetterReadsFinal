package com.example.betterreads.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.management.remote.rmi.RMIConnectionImpl;

public class AddBookDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private Integer releasedYear;

    public AddBookDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(Integer releasedYear) {
        this.releasedYear = releasedYear;
    }
}
