package com.example.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Products {

	@Id
	private String id;
	private String name;
	private String description;
	private int cost;
	private int quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Products(String id, String name, String description, int cost, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
