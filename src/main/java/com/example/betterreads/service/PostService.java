package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;

public interface PostService {
    void addPost(AddPostDTO post);
    void deletePost();
}
