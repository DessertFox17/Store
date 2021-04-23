package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubcategoryCrudRepository extends CrudRepository<SubcategoryEntity, Integer> {

    @Query(
            value = "SELECT s_name, pr_name, cat_name" +
                    " FROM subcategory s  " +
                    "  INNER JOIN product p" +
                    "   ON s.subcategory_id = p.subcategory_id" +
                    "    INNER JOIN category c" +
                    "     ON s.category_id = c.category_id" +
                    "       WHERE p.pr_name like %:name%",
            nativeQuery = true)
    List<String> smartFilter(@Param("name")String name);

}
