package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.DynamicFilterDto;
import com.Vicio.Games.domain.dto.NewProductDto;
import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.exceptions.NotFound;
import com.Vicio.Games.persistence.crud.SubcategoryCrudRepository;
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

    @Autowired
    private SubcategoryCrudRepository scrud;

    public Map<String, Object> smartFilter(String name) {

        Map<String, Object> map = new HashMap<>();


        List<String> pProducts = scrud.smartFilter(name);

        List<Object> results = new ArrayList<>(pProducts);

        map.put("results", results);

        return map;
    }

    public Map<String, Object> dynamicFilter(String result, String request, int limit, int offset) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<DynamicFilterDto> products = new ArrayList<>();

        List<ProductEntity> pProducts = productDomainRepository.dynamicFilter(result, request, limit, offset);

        pProducts.forEach(productEntity -> products.add(modelMapper.map(productEntity, DynamicFilterDto.class)));

        map.put("results", products);

        return map;
    }


    public Map<String, Object> findByID(int prId, boolean request) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        ProductEntity pProduct = productDomainRepository.findProductByID(prId)
                .orElseThrow(() -> new NotFound("User doesn´t exist, please return a valid Id" + prId));

        NewProductDto product = modelMapper.map(pProduct, NewProductDto.class);

        Integer counter = pProduct.getSearchCounter();
        counter += 1;
        pProduct.setSearchCounter(counter);
        productDomainRepository.newProduct(pProduct);


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
        map.put("searchCounter", product.getSearchCounter());
        if (!request) map.put("subcategory", product.getSubcategory());

        return map;

    }

    public Map<String, Object> updateProduct(NewProductDto newProductDto) {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        ProductEntity productEntity = modelMapper.map(newProductDto, ProductEntity.class);
        productDomainRepository.newProduct(productEntity);

        return null;
    }


}
