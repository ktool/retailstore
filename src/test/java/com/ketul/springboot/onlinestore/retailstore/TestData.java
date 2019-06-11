package com.ketul.springboot.onlinestore.retailstore;

import java.util.ArrayList;
import java.util.List;

import com.ketul.springboot.onlinestore.retailstore.bl.model.request.Product;

public class TestData {

	Long userId = (long) 1;

	List<Product> products = new ArrayList();
	Product p1 = new Product("ReebookShoes", (double) 2000, "Shoes");
	Product p2 = new Product("Sugar", (double) 400, "GROCERY");
	Product p3 = new Product("UnoCards", (double) 2000, "Toy");

	public TestData() {
		products.add(p1);
		products.add(p2);
		products.add(p3);
	}

}
