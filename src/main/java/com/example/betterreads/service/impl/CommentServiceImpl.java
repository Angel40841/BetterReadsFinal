package com.example.betterreads.service.impl;

import com.example.betterreads.model.entites.Comment;
import com.example.betterreads.repositories.CommentRepository;
import com.example.betterreads.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
