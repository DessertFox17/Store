package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.repository.PurchaseDomaindRepository;
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

        pPurchases.forEach(purchaseEntity -> purchases.add(modelMapper.map(purchaseEntity,NewPurchaseDto.class)));

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
}
