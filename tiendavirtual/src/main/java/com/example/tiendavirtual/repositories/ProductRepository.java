package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entities.ProductEntity;

@Repository 
@Primary 

public class ProductRepository {

    private final IProductJpaRepository repository;

    ProductRepository(IProductJpaRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> getAllProductEntity(){
        List<ProductEntity> productsEntity = repository.findAll();
        return productsEntity;
    }
    
    public ProductEntity getByCode(String code){
        ProductEntity productEntity = repository.findByCode(code);
        return productEntity;
    }

    public ProductEntity getById(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
