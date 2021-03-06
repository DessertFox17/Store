package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.DynamicFilterDto;
import com.Vicio.Games.domain.dto.NewProductDto;
import com.Vicio.Games.domain.repository.ProductDomainRepository;
import com.Vicio.Games.persistence.crud.ProductCrudRepository;
import com.Vicio.Games.persistence.crud.SubcategoryCrudRepository;
import com.Vicio.Games.persistence.entity.ProductEntity;
import javassist.NotFoundException;
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

    public ProductService(ProductCrudRepository productCrudRepository) {
    }


    public Map<String, Object> smartFilter(String name) {

        Map<String, Object> map = new HashMap<>();

        List<String> pProducts = scrud.smartFilter(name);
        List<Object> results = new ArrayList<>(pProducts);
        map.put("results", results);

        return map;
    }

    public Map<String, Object> dynamicFilter(String result, String request, int limit, int offset) {

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> page = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        List<DynamicFilterDto> products = new ArrayList<>();

        List<ProductEntity> pProducts = productDomainRepository.dynamicFilter(result, request, limit, offset);
        Long counter = productDomainRepository.dynamicFilterCounter(result);

        pProducts.forEach(productEntity -> products.add(modelMapper.map(productEntity, DynamicFilterDto.class)));

        page.put("limit", limit);
        page.put("offset", offset);
        page.put("total", counter);

        map.put("results", products);
        map.put("page request", page);

        return map;
    }


    public Map<String, Object> findByID(int prId, boolean request) throws Throwable {

        Map<String, Object> map = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();

        ProductEntity pProduct = productDomainRepository.findProductByID(prId).orElse(null);

        if(pProduct == null){
            throw new NotFoundException(String.format("The product with id: %s does not exist",prId));
        }

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
        if (request) map.put("subcategory", product.getSubcategory());

        return map;
    }
}
