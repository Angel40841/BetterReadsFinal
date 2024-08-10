package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.repositories.PostRepository;
import com.example.betterreads.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        post.setPostAuthor("Author");
        postRepository.save(map(post));

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

    private PostEntity map(AddPostDTO postData) {
        return modelMapper.map(postData, PostEntity.class);
    }

}
