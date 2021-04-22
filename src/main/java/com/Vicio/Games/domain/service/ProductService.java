package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.ProductDto;
import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductDomainRepository productDomainRepository;

    public Map<String, Object> findproductsNative(String name) {

        Map<String, Object> map = new HashMap<>();
        //ModelMapper modelMapper = new ModelMapper();
        //List<ProductDto> products = new ArrayList<>();

        List<Object[]> pProducts = productDomainRepository.findproductsNative(name);

        //pProducts.forEach(productEntity -> products.add(modelMapper.map(productEntity, ProductDto.class)));

        map.put("products", pProducts);

        return map;
    }

    public Map<String, Object> findByID(int prId, boolean request) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        ProductEntity pProduct = productDomainRepository.findProductByID(prId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id" + prId));

        ProductDto product = modelMapper.map(pProduct, ProductDto.class);

        System.out.println(request);


        map.put("prId", product.getPrId());
        map.put("name", product.getName());
        map.put("price", product.getPrice());
        map.put("stock", product.getStock());
        map.put("shipCost", product.getShipCost());
        map.put("tumbnail", product.getTumbnail());
        map.put("publicDate", product.getPublicDate());
        map.put("description", product.getDescription());
        map.put("details", product.getDetails());
        map.put("comments", product.getComments());
        map.put("images", product.getImages());
        if(!request) map.put("subcategory", product.getSubcategory());

        return map;

    }



}
