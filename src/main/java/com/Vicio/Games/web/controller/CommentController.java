package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.NewCommentDto;
import com.Vicio.Games.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/new")
    public Map<String, Object> newCommment(@RequestBody NewCommentDto newCommentDto){
        return commentService.newComment(newCommentDto);
    }
}
