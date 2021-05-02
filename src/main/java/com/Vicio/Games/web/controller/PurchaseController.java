package com.Vicio.Games.web.controller;


import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/{usId}")
    public Map<String, Object> getByClient(@PathVariable("usId") int usId) {
        return purchaseService.getByClient(usId);
    }

    @PostMapping("/new")
    public Map<String, Object> newPurchase(@RequestBody NewPurchaseDto newPurchaseDto) {
        return purchaseService.newPurchase(newPurchaseDto);
    }
}