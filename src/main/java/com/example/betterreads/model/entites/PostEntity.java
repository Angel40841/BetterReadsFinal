package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private java.lang.String postContent;
    @Column(nullable = false)
    private java.lang.String title;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User postAuthor;


    public PostEntity() {
    }

    public String getPostContent() {
        return postContent;
    }

    public User getPostAuthor() {
        return postAuthor;
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
        this.postAuthor = user;
    }
}
