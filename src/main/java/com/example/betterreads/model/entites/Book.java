package com.example.betterreads.model.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(name = "cover_image_url")
    private String coverImageUrl;
    @Column(nullable = false)
    private Integer releasedYear;
    @Column(name = "author_name", nullable = false)
    private String author;
    @Column(nullable = false)
    private int rating;

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}
