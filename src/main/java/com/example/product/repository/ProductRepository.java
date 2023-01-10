package com.example.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.product.entity.Products;

@Repository
public interface ProductRepository  extends MongoRepository<Products, String>{

}
