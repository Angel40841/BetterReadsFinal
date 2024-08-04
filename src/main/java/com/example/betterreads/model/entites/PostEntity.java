package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String postContent;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public PostEntity() {
    }

    public String getPostContent() {
        return postContent;
    }

    public User getPostAuthor() {
        return user;
    }

    public String getTitle() {
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
}
