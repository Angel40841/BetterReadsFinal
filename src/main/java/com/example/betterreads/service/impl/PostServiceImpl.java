package com.example.betterreads.service.impl;

import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.repositories.PostRepository;
import com.example.betterreads.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public void addPost(PostEntity post) {
        postRepository.save(post);

    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(getPostById(id));
    }

    @Override
    public PostEntity getPostById(Long id) {
        Optional<PostEntity> byId = postRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return postRepository.findById(id);
    }


}
