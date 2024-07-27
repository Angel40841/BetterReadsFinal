package com.example.betterreads.model.entites;

import com.example.betterreads.model.entites.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String postContent;
    @Column(nullable = false)
    private String title;
    @Column
    private String postAuthor;

    public String getPostContent() {
        return postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
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

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }
}
