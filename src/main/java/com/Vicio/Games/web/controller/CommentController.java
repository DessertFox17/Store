package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.NewCommentDto;
import com.Vicio.Games.domain.service.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "New comment", notes = "This endpoint creates a new comment")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Bad Request")
    })
    public Map<String, Object> newCommment(@RequestBody NewCommentDto commentPayload){
        return commentService.newComment(commentPayload);
    }
}
