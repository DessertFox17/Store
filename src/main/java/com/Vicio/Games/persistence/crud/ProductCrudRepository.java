package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    @Query(
            value = "SELECT pr_name FROM product  WHERE product_id = :prId",
            nativeQuery = true)
    List<ProductEntity> findproductsNative(@Param("prId")int prId);
}
