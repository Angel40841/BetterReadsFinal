package com.example.betterreads.service;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void addPost(AddPostDTO post);
    void deletePost(Long id);

    PostEntity getPostById(Long id);

    List<PostEntity> getAllPosts();

    Optional<PostEntity> findById(Long id);
}
