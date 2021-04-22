package com.Vicio.Games.web.controller;


import com.Vicio.Games.domain.dto.ImageDto;
import com.Vicio.Games.domain.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/new")
    public Map<String, Object> newImage(@RequestBody ImageDto imageDto){
        return imageService.newImage(imageDto);
    }

}
