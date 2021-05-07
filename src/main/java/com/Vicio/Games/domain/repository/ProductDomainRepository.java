package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    Optional<ProductEntity> findProductByID(int prId);
    List<ProductEntity> dynamicFilter(String result, String request, int limit, int offset);
    Long dynamicFilterCounter(String result);
    ProductEntity newProduct(ProductEntity productEntity);
    Double getPrice(int prId);
    Double getShipCost(int prId);
}
