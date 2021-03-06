package com.Vicio.Games.web.controller;


import com.Vicio.Games.domain.dto.NewImageDto;
import com.Vicio.Games.domain.service.ImageService;
import com.Vicio.Games.exceptions.ErrorHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/new")
    @ApiOperation(value = "New image", notes = "This endpoint stores a new image for a product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> newImage(@Valid @RequestBody NewImageDto imagePayload, BindingResult bindingResult){
        return imageService.newImage(imagePayload,bindingResult);
    }

}
