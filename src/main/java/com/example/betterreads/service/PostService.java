package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;

import java.util.List;

public interface PostService {
    void addPost(AddPostDTO post);
    void deletePost(Long id);

    PostEntity getPostById(Long id);

    List<AddPostDTO> getAll();
}
