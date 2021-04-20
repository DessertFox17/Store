package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentCrudRepository extends CrudRepository<CommentEntity, Integer> {
}
