package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.repositories.PostRepository;
import com.example.betterreads.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPost(AddPostDTO post) {
        postRepository.save(map(post));
    }

    @Override
    public void deletePost() {

    }
    private PostEntity map(AddPostDTO postData){
        PostEntity mappedPost = modelMapper.map(postData, PostEntity.class);
        return mappedPost;
    }
}
