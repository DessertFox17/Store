package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/native/{prId}")
    public Map<String, Object> findproductsNative(@PathVariable("prId") int prId){
        return productService.findproductsNative(prId);
    }

    @GetMapping("/{id}")
    public Map<String, Object> findByID(@RequestParam(required = false) String q, @PathVariable("id") int prid){
        boolean request = q == null;
        return productService.findByID(prid,request);
    }


}
