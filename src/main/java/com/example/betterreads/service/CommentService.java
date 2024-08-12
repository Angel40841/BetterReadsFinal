package com.example.betterreads.service;

import com.example.betterreads.model.entites.Comment;

public interface CommentService {
    void addComment(Comment comment);
    void deleteComment(Long id);

}
