package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.ImageEntity;

public interface ImageDomainRepository{
    ImageEntity newImage(ImageEntity imageEntity);

}
