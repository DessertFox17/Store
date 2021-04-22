package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.SubcategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubcategoryCrudRepository extends CrudRepository<SubcategoryEntity, Integer> {
}
