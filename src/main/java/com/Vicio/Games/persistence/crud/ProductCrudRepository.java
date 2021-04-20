package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
