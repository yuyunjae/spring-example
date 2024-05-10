package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }

    @GetMapping("/comment/{content}")
    public List<Comment> uploadComment(@PathVariable("content") String content){
        Comment comment = new Comment(content);

        commentRepository.save(comment);
        return commentRepository.findAll();
    }
}
