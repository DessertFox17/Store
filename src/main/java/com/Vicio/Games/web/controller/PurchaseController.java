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

    @GetMapping("/client/{usId}")
    public Map<String, Object> getByClient(@PathVariable("usId") int usId) {
        return purchaseService.getByClient(usId);
    }

    @PostMapping("/new")
    public Map<String, Object> newPurchase(@RequestBody NewPurchaseDto newPurchaseDto) {
        return purchaseService.newPurchase(newPurchaseDto);
    }

    @GetMapping("/find/{puId}")
    public Map<String, Object> getById(@PathVariable("puId") int puId){
        return purchaseService.getById(puId);
    }

    @PutMapping("/update")
    public Map<String, Object> updatePurchase(@RequestBody NewPurchaseDto newPurchaseDto) {
        return purchaseService.updatePurchase(newPurchaseDto);
    }

    @GetMapping("/find/{usId}/{stId}")
    public Map<String, Object> getByUserandStatus(@PathVariable("usId") int usId, @PathVariable("stId")int stId){
        return purchaseService.getByUserandStatus(usId,stId);
    }

}
