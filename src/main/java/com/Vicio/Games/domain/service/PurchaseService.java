package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.dto.ShowPurchaseDto;
import com.Vicio.Games.domain.repository.PurchaseDomaindRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.PurchaseEntity;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
public class PurchaseService {

    @Autowired
    private PurchaseDomaindRepository purchaseDomaindRepository;

    public Map<String, Object> getByClient(int usId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<NewPurchaseDto> purchases = new ArrayList<>();

        List<PurchaseEntity> pPurchases = purchaseDomaindRepository.getByClient(usId);

        pPurchases.forEach(purchaseEntity -> purchases.add(modelMapper.map(purchaseEntity, NewPurchaseDto.class)));

        map.put("Purchases", purchases);

        return map;
    }

    public Map<String, Object> newPurchase(NewPurchaseDto newPurchaseDto) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        PurchaseEntity purchase = modelMapper.map(newPurchaseDto, PurchaseEntity.class);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));
        purchaseDomaindRepository.newPurchase(purchase);

        map.put("Message", "Products purchased succesfully");
        return map;
    }

    public Map<String, Object> updatePurchase(NewPurchaseDto newPurchaseDto, int puId) {

        Map<String, Object> map = new HashMap<>();

        PurchaseEntity purchase = purchaseDomaindRepository.getById(puId)
                .orElseThrow(() -> new NotFound("Purchase doesn't exist"));


        purchase.setStId(newPurchaseDto.getStId());

        purchaseDomaindRepository.updatePurchase(purchase);

        map.put("Message", "Purchase updated succesfully");
        return map;
    }

    public Map<String, Object> getById(int puId) {
        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        PurchaseEntity pPurchase = purchaseDomaindRepository.getById(puId)
                .orElseThrow(() -> new NotFound("Purchase not found"));

        ShowPurchaseDto purchase = modelMapper.map(pPurchase, ShowPurchaseDto.class);

        map.put("Purchase", purchase);

        return map;
    }
}
