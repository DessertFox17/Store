package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
