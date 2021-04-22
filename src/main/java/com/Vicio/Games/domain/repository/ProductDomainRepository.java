package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.ProductEntity;
import com.Vicio.Games.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    Optional<ProductEntity> findProductByID(int prId);
    List<ProductEntity> findproductsNative(int prId);
}
