package com.example.betterreads.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddPostDTO {
    @NotBlank
    @Size(min = 3)
    private String title;
    @NotBlank
    @Size(min = 3)
    private String postContent;
    private String postAuthor;

    public AddPostDTO() {
    }

    public String getPostContent() {
        return postContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }
}

