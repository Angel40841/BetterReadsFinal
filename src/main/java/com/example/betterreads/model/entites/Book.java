package com.example.betterreads.model.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer releasedYear;
    @Column(name = "author_name", nullable = false)
    private String author;

    public String getTitle() {
        return title;
    }

    public Integer getReleasedYear() {
        return releasedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleasedYear(Integer releasedYear) {
        this.releasedYear = releasedYear;
    }

    public void setAuthor(String authorName) {
        this.author = authorName;
    }
}
