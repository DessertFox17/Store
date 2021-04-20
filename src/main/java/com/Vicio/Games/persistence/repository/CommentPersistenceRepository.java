package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.CommentDomainRepository;
import com.Vicio.Games.persistence.crud.CommentCrudRepository;
import com.Vicio.Games.persistence.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentPersistenceRepository implements CommentDomainRepository {

    @Autowired
    private CommentCrudRepository commentCrudRepository;

    @Override
    public CommentEntity newComment(CommentEntity commentEntity) {
        return commentCrudRepository.save(commentEntity);
    }
}
