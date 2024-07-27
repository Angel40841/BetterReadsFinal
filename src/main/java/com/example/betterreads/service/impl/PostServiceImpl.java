package com.example.betterreads.service.impl;

import com.example.betterreads.model.dto.AddPostDTO;
import com.example.betterreads.model.entites.PostEntity;
import com.example.betterreads.repositories.PostRepository;
import com.example.betterreads.service.PostService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
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
    @Transactional
    @Override
    public List<AddPostDTO> getAll() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private AddPostDTO mapToDto(PostEntity postEntity) {
        AddPostDTO mappedDto = modelMapper.map(postEntity, AddPostDTO.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        mappedDto.setPostAuthor(user);
        return mappedDto;
    }


    private PostEntity map(AddPostDTO postData) {
        PostEntity mappedPost = modelMapper.map(postData, PostEntity.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        mappedPost.setPostAuthor(user);

        return mappedPost;
    }

}
