package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewPurchaseDto;
import com.Vicio.Games.domain.dto.ShowCartDto;
import com.Vicio.Games.domain.dto.ShowPurchaseDto;
import com.Vicio.Games.domain.dto.UpdatePurchaseStatusDto;
import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.domain.repository.PurchaseDomaindRepository;
import com.Vicio.Games.domain.repository.StatusDomainRepository;
import com.Vicio.Games.persistence.entity.PurchaseEntity;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseDomaindRepository purchaseDomaindRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private StatusDomainRepository statusDomainRepository;

    @Autowired
    private ProductDomainRepository productDomainRepository;

    public Map<String, Object> getByClient(int usId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<ShowPurchaseDto> purchases = new ArrayList<>();

        List<PurchaseEntity> pPurchases = purchaseDomaindRepository.getByClient(usId);

        pPurchases.forEach(purchaseEntity -> purchases.add(modelMapper.map(purchaseEntity, ShowPurchaseDto.class)));

        map.put("Purchases", purchases);

        return map;
    }

    public Map<String, Object> newPurchase(NewPurchaseDto newPurchaseDto, BindingResult bindingResult){

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("all or some mandatory fields are incomplete");
        }

        PurchaseEntity purchase = modelMapper.map(newPurchaseDto, PurchaseEntity.class);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));

        purchase.getProducts().
                forEach(productPurchaseEntity -> productPurchaseEntity
                        .setTotProdsCost(productDomainRepository.getPrice(productPurchaseEntity
                                .getProduct().getPrId()) * productPurchaseEntity.getQuantity()));

        purchase.getProducts()
                .forEach(productPurchaseEntity -> productPurchaseEntity
                .setTotShipCost(productDomainRepository.getShipCost(productPurchaseEntity.getProduct()
                        .getPrId()) * productPurchaseEntity.getQuantity()));

        purchase.getProducts()
                .forEach(productPurchaseEntity -> productPurchaseEntity
                        .setPurchaseCost(productPurchaseEntity.getTotProdsCost() + productPurchaseEntity
                                .getTotShipCost()));

        purchaseDomaindRepository.newPurchase(purchase);

        map.put("Message", "Products purchased succesfully");
        map.put("New Purchase id: ", purchase.getPuId());
        return map;
    }

    public Map<String, Object> updatePurchase(UpdatePurchaseStatusDto purchasePayload, BindingResult bindingResult) throws NotFoundException {

        Map<String, Object> map = new HashMap<>();

        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("all or some mandatory fields are incomplete");
        }

        PurchaseEntity purchase = purchaseDomaindRepository.getById(purchasePayload.getPuId()).orElse(null);

        if(purchase == null){
            throw new NotFoundException(String.format("The purchase with id: %s does not exist",purchasePayload.getPuId()));
        }

        purchase.setStId(purchasePayload.getStId());
        purchaseDomaindRepository.updatePurchase(purchase);

        notificationService.sendNotification(purchasePayload.getUsId(), purchasePayload.getStId());

        map.put("Message", "Purchase updated succesfully");
        map.put("New Status", statusDomainRepository.findStatusById(purchasePayload.getStId()).get().getName());
        return map;
    }

    public Map<String, Object> getById(int puId) throws NotFoundException {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        PurchaseEntity pPurchase = purchaseDomaindRepository.getById(puId).orElse(null);

        if(pPurchase == null){
            throw new NotFoundException(String.format("The purchase with id: %s does not exist",puId));
        }
        ShowPurchaseDto purchase = modelMapper.map(pPurchase, ShowPurchaseDto.class);

        map.put("Purchase", purchase);

        return map;
    }

    public Map<String, Object> getByUserandStatus(int usId) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<ShowCartDto> purchases = new ArrayList<>();

        List<PurchaseEntity> pPurchases = purchaseDomaindRepository.getByUserandStatus(usId, 1);
        pPurchases.forEach(purchaseEntity -> purchases.add(modelMapper.map(purchaseEntity, ShowCartDto.class)));

        map.put("Purchases in Cart", purchases);

        return map;
    }
}
