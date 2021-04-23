package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {

     @Autowired
     private SubcategoryService subcategoryService;

}
