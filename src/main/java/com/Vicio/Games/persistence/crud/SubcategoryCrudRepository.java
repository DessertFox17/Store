package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubcategoryCrudRepository extends CrudRepository<SubcategoryEntity, Integer> {
}
