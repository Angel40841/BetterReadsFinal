package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_by_user_and_bookid")
public class UserBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "started_date")
    private LocalDate startedDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;

    @Column(name = "reading_status")
    private java.lang.String readingStatus;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public void setReadingStatus(java.lang.String readingStatus) {
        this.readingStatus = readingStatus;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public java.lang.String getReadingStatus() {
        return readingStatus;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {

    }
}


