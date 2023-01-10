package com.example.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Products;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository productRepository;
	public Products addProduct(Products product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Products getProducts(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	public void deleteProducts(String id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

	public Products updateProducts(Products product, String id) {
		Optional<Products> op =productRepository.findById(id);
		if(op.isPresent()) {
			Products products= op.get();
			products.setName(product.getName());
			products.setDescription(product.getDescription());
			products.setCost(product.getCost());
			products.setQuantity(product.getQuantity());
			
			return productRepository.save(products);
		}
		return null;
	}

}
