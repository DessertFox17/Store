package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    Optional<ProductEntity> findProductByID(int prId);
    List<Object[]> findproductsNative(String name);
}
