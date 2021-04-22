package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageCrudRepository extends CrudRepository<ImageEntity,Integer> {
}
