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

    @GetMapping("/smartfilter")
    public Map<String, Object> smartFilter(@RequestParam String name){
        return productService.smartFilter(name);
    }

    @GetMapping("/{id}")
    public Map<String, Object> findByID(@RequestParam(required = false) String q, @PathVariable("id") int prid){
        boolean request = q == null;
        return productService.findByID(prid,request);
    }

    @GetMapping("/dynamicfilter")
    public Map<String, Object> dynamicFilter(@RequestParam String result,
                                             @RequestParam int limit,
                                             @RequestParam int offset,
                                             @RequestParam(required = false) boolean alpha,
                                             @RequestParam(required = false) boolean min,
                                             @RequestParam(required = false) boolean max){
        String request = "";
        if(alpha & !min & !max ) {request = "alpha";}
        if(min & !alpha & !max) {request = "min";}
        if(max & !min & !alpha) {request = "max";}

        return productService.dynamicFilter(result, request, limit,offset);
    }



}
