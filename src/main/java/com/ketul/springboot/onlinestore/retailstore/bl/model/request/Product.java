package com.ketul.springboot.onlinestore.retailstore.bl.model.request;

import lombok.Getter;
import lombok.Setter;

public class Product {

	String productName;
	Double price;
	String category;

	public Product(String productName, Double price, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
