package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.service.ProductService;
import com.Vicio.Games.exceptions.BadRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/smartfilter")
    @ApiOperation(value = "Smart filter",
                  notes = "This endpoint scans the database searching for all related with the param name")
    @ApiResponse(code = 200, message = "Ok")
    public Map<String, Object> smartFilter(@RequestParam String name){
        return productService.smartFilter(name);
    }

    @GetMapping("/specific")
    @ApiOperation(value = "Find a specific product",
            notes = "This endpoint finds a product by its id, with request = true, shows the category and subcategory")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> findByID(@RequestParam(required = false) boolean request, @RequestParam int id){
        return productService.findByID(id,request);
    }

    @GetMapping("/dynamicfilter")
    @ApiOperation(value = "Dynamic products filter",
            notes = "This endpoint returns a list of products related with the param," +
                    "with pagination and ordered by min price, or max price or alphabetics")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    public Map<String, Object> dynamicFilter(@Valid @RequestParam String result,
                                             @RequestParam(required = false, defaultValue = "5") int limit,
                                             @RequestParam(required = false, defaultValue = "0") int offset,
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
