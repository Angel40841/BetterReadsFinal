package com.example.betterreads.model.dto;


import com.example.betterreads.model.entites.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddPostDTO {
    @NotBlank
    @Size(min = 3)
    private String title;
    @NotBlank
    @Size(min = 3)
    private String postContent;

    private User postAuthor;

    public AddPostDTO() {
    }

    public String getPostContent() {
        return postContent;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(@NotBlank @Size(min = 3) String title) {
        this.title = title;
    }

    public void setPostContent(@NotBlank @Size(min = 3) String postContent) {
        this.postContent = postContent;
    }

    public User getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(User postAuthor) {
        this.postAuthor = postAuthor;
    }
}

