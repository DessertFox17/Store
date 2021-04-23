package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.ProductDto;
import com.Vicio.Games.domain.repository.SubcategoryDomainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryDomainRepository subcategoryDomainRepository;


}
