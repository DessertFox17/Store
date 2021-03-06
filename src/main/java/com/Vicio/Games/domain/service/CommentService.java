package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewCommentDto;
import com.Vicio.Games.domain.repository.CommentDomainRepository;
import com.Vicio.Games.persistence.crud.CommentCrudRepository;
import com.Vicio.Games.persistence.entity.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentDomainRepository commentDomainRepository;

    public CommentService(CommentCrudRepository commentCrudRepository) {
    }

    public Map<String, Object> newComment(NewCommentDto newCommentDto, BindingResult bindingResult) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("all or some mandatory fields are incomplete");
        }

        CommentEntity commentEntity = modelMapper.map(newCommentDto, CommentEntity.class);
        commentDomainRepository.newComment(commentEntity);
        map.put("Message", "Product commented succesfully");

        return map;
    }
}
