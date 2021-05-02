package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.persistence.crud.ProductCrudRepository;
import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
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
    public List<ProductEntity> dynamicFilter(String name, String request, int limit, int offset) {

        if(request == "alpha"){
            return productCrudRepository
                    .dynamicFilter(name.toLowerCase(Locale.ROOT), PageRequest.of(offset,limit,Sort.by(Sort.Direction.ASC,"name")));
        }
        if(request == "min"){
            return productCrudRepository
                    .dynamicFilter(name.toLowerCase(Locale.ROOT), PageRequest.of(offset,limit,Sort.by(Sort.Direction.ASC, "price")));
        }
        if(request == "max"){
            return productCrudRepository
                    .dynamicFilter(name.toLowerCase(Locale.ROOT),  PageRequest.of(offset,limit,Sort.by(Sort.Direction.DESC, "price")));
        }

        return productCrudRepository.dynamicFilter(name.toLowerCase(Locale.ROOT),  PageRequest.of(offset,limit,Sort.by(Sort.Direction.ASC, "prId")));
    }

    @Override
    public ProductEntity newProduct(ProductEntity productEntity) {
        return productCrudRepository.save(productEntity);
    }
}
