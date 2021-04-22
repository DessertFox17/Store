package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    @Query(
            value = "SELECT s_name, pr_name" +
                    " FROM subcategory s  " +
                    "  INNER JOIN product p" +
                    "   ON s.subcategory_id = p.subcategory_id" +
                    "     WHERE p.pr_name like %:name%",
            nativeQuery = true)
    List<Object[]> findproductsNative(@Param("name")String name);
}
