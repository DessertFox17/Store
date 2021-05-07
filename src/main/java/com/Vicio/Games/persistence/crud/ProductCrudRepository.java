package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.ProductEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p" +
            " join p.subcategory s" +
            " join s.category c" +
            " where lower(p.name) like %?1%" +
            " or lower(s.name) like %?1%" +
            " or lower(c.name) like %?1%")
    List<ProductEntity> dynamicFilter(String result, PageRequest sort);


    @Query(
            value = " SELECT pr_price FROM product p " +
                    " WHERE product_id = :prId "
            ,nativeQuery = true)
    Double getPrice(int prId);

    @Query(
            value = " SELECT pr_sendcost FROM product p " +
                    " WHERE product_id = :prId "
            ,nativeQuery = true)
    Double getShipCost(int prId);

}
