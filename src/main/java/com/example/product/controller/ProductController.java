package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Products;
import com.example.product.service.ProductService;


@RestController
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Products addDetails(@RequestBody Products product) {
		return productService.addProduct(product);
	}
	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts() {
		return productService.getAllProducts();
	}
	@GetMapping("/get/{id}")
	public Products getProducts(@PathVariable String id) {
		return productService.getProducts(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProducts(@PathVariable String id) {
		productService.deleteProducts(id);
	}
	@PutMapping("/update/{id}")
	public Products updateProducts(@RequestBody Products product,@PathVariable String id)  {
		return productService.updateProducts(product, id);
	}
}
