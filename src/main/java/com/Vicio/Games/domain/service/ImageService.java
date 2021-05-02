package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewImageDto;
import com.Vicio.Games.domain.repository.ImageDomainRepository;
import com.Vicio.Games.persistence.entity.ImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class ImageService {

    @Autowired
    private ImageDomainRepository imageDomainRepository;


    public Map<String, Object> newImage(NewImageDto newImageDto){

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        ImageEntity image = modelMapper.map(newImageDto, ImageEntity.class);
        imageDomainRepository.newImage(image);

        map.put("Message", "Image saved succesfully");
        return map;
    }
}
