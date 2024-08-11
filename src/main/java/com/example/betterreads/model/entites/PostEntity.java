package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private java.lang.String postContent;
    @Column(nullable = false)
    private java.lang.String title;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public PostEntity() {
    }

    public String getPostContent() {
        return postContent;
    }

    public User getPostAuthor() {
        return user;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
