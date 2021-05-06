package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewImageDto;
import com.Vicio.Games.domain.repository.ImageDomainRepository;
import com.Vicio.Games.exceptions.BadRequest;
import com.Vicio.Games.persistence.entity.ImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;


@Service
public class ImageService {

    @Autowired
    private ImageDomainRepository imageDomainRepository;


    public Map<String, Object> newImage(NewImageDto newImageDto, BindingResult bindingResult) throws BadRequest {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        if(bindingResult.hasErrors()){
            throw new BadRequest("Mandatory fields incomplete");
        }

        ImageEntity image = modelMapper.map(newImageDto, ImageEntity.class);
        imageDomainRepository.newImage(image);

        map.put("Message", "Image saved succesfully");
        return map;
    }
}
