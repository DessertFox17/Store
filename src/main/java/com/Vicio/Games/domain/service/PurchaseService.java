package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.dto.ShowPurchaseDto;
import com.Vicio.Games.domain.repository.PurchaseDomaindRepository;
import com.Vicio.Games.domain.repository.StatusDomainRepository;
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

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private StatusDomainRepository statusDomainRepository;

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

    public Map<String, Object> updatePurchase(NewPurchaseDto newPurchaseDto) {

        Map<String, Object> map = new HashMap<>();

        PurchaseEntity purchase = purchaseDomaindRepository.getById(newPurchaseDto.getPuId())
                .orElseThrow(() -> new NotFound("Purchase doesn't exist"));


        purchase.setStId(newPurchaseDto.getStId());
        purchaseDomaindRepository.updatePurchase(purchase);

        notificationService.sendNotification(newPurchaseDto.getUsId(),newPurchaseDto.getStId());


        map.put("Message", "Purchase updated succesfully");
        map.put("New Status", statusDomainRepository.findStatusById(newPurchaseDto.getStId()).get().getName());
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

    public Map<String, Object> getByUserandStatus(int usId, int stId){

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<ShowPurchaseDto> purchases = new ArrayList<>();

        List<PurchaseEntity> pPurchases = purchaseDomaindRepository.getByUserandStatus(usId,stId);
        pPurchases.forEach(purchaseEntity -> purchases.add(modelMapper.map(purchaseEntity, ShowPurchaseDto.class)));

        map.put("Purchases in Cart",purchases);

        return map;
    }
}
