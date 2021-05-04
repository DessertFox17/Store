package com.Vicio.Games.web.controller;


import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/client/{id}")
    @ApiOperation(value = "Find a purchases by client", notes = "This endpoint gets all the purchases of a client")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> getByClient(@PathVariable("id") int id) {
        return purchaseService.getByClient(id);
    }

    @PostMapping("/new")
    @ApiOperation(value = "New Purchase", notes = "This endpoint creates a new purchase")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> newPurchase(@RequestBody NewPurchaseDto purchasePayload) {
        return purchaseService.newPurchase(purchasePayload);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Find a purchases by id", notes = "This endpoint gets a purchase by its id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> getById(@PathVariable("id") int id){
        return purchaseService.getById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update purchase status",
                  notes = "This endpoint updates the status of a purchase and notify the client")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> updatePurchase(@RequestBody NewPurchaseDto purchasePayload) {
        return purchaseService.updatePurchase(purchasePayload);
    }

    @GetMapping("/cart/{id}")
    @ApiOperation(value = "Find a the purchases in cart",
                  notes = "This endpoint gets the purchases in cart of an user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, Object> getByUserandStatus(@PathVariable("id") int id){
        return purchaseService.getByUserandStatus(id);
    }

}
