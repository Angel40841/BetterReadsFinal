package com.example.betterreads.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddPostDTO {
    @NotBlank
    @Size(min = 3)
    private java.lang.String title;
    @NotBlank
    @Size(min = 3)
    private java.lang.String postContent;
    @NotBlank
    private String postAuthor;

    public AddPostDTO() {
    }

    public java.lang.String getPostContent() {
        return postContent;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @Size(min = 3) java.lang.String title) {
        this.title = title;
    }

    public void setPostContent(java.lang.String postContent) {
        this.postContent = postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }
}

