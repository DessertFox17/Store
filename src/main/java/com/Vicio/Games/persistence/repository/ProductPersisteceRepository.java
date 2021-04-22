package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.persistence.crud.ProductCrudRepository;
import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductPersisteceRepository implements ProductDomainRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public Optional<ProductEntity> findProductByID(int prId) {
        return productCrudRepository.findById(prId);
    }

    @Override
    public List<Object[]> findproductsNative(String name) {
        return productCrudRepository.findproductsNative(name);
    }
}
