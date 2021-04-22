package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.ImageDomainRepository;
import com.Vicio.Games.persistence.crud.ImageCrudRepository;
import com.Vicio.Games.persistence.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImagePersistenceRepository implements ImageDomainRepository {

    @Autowired
    private ImageCrudRepository imageCrudRepository;

    @Override
    public ImageEntity newImage(ImageEntity imageEntity) {
        return imageCrudRepository.save(imageEntity);
    }
}
