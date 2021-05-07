package com.Vicio.Games.web.controller;


import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.dto.UpdatePurchaseStatusDto;
import com.Vicio.Games.domain.service.PurchaseService;
import com.Vicio.Games.exceptions.BadRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/client")
    @ApiOperation(value = "Find a purchases by client", notes = "This endpoint gets all the purchases of a client")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> getByClient(@RequestParam int id) {
        return purchaseService.getByClient(id);
    }

    @PostMapping("/new")
    @ApiOperation(value = "New Purchase", notes = "This endpoint creates a new purchase")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> newPurchase(@Valid @RequestBody NewPurchaseDto purchasePayload, BindingResult bindingResult) throws BadRequest {
        return purchaseService.newPurchase(purchasePayload, bindingResult);
    }

    @GetMapping("/specific")
    @ApiOperation(value = "Find a purchases by id", notes = "This endpoint gets a purchase by its id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> getById(@RequestParam int id){
        return purchaseService.getById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update purchase status",
                  notes = "This endpoint updates the status of a purchase and notify the client by email")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> updatePurchase(@Valid @RequestBody UpdatePurchaseStatusDto purchasePayload, BindingResult bindingResult) throws BadRequest {
        return purchaseService.updatePurchase(purchasePayload, bindingResult);
    }

    @GetMapping("/cart")
    @ApiOperation(value = "Find a the purchases in cart",
                  notes = "This endpoint gets the purchases in cart of an user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
    })
    public Map<String, Object> getByUserandStatus(@RequestParam int id){
        return purchaseService.getByUserandStatus(id);
    }

}
