package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.CommentEntity;
import com.Vicio.Games.persistence.entity.UserEntity;

public interface CommentDomainRepository {
    CommentEntity newComment(CommentEntity commentEntity);
}
