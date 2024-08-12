package com.example.betterreads.controller;

import com.example.betterreads.model.entites.Comment;
import com.example.betterreads.service.CommentService;
import com.example.betterreads.service.PostService;
import com.example.betterreads.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    private final UserService userService;
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(UserService userService, CommentService commentService, PostService postService) {
        this.userService = userService;
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam String content, @RequestParam Long postId, @RequestParam Long userId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("No such user found")));
        comment.setPost(postService.getAllPosts().stream().filter(post -> post.getId().equals(postId)).findFirst().orElseThrow(()->new IllegalArgumentException("No such post found!")));
        commentService.addComment(comment);
        return "redirect:/home";
    }
}
