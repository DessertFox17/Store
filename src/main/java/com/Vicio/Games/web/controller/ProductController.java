package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.service.ProductService;
import com.Vicio.Games.domain.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/smartFilter")
    public Map<String, Object> smartFilter(@RequestParam String name){
        return productService.smartFilter(name);
    }

    @GetMapping("/{id}")
    public Map<String, Object> findByID(@RequestParam(required = false) String q, @PathVariable("id") int prid){
        boolean request = q == null;
        return productService.findByID(prid,request);
    }


}
