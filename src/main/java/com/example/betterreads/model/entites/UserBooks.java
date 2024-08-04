package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_by_user_and_bookid")
public class UserBooks extends BaseEntity {


    @Column(name = "started_date")
    private LocalDate startedDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;

    @Column(name = "reading_status")
    private String readingStatus;

    @Column(name = "rating")
    private int rating;

    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<Book> books;

    public UserBooks() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public int getRating() {
        return rating;
    }

    public String getReadingStatus() {
        return readingStatus;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }
}


