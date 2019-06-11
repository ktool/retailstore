package com.ketul.springboot.onlinestore.retailstore.bl.model.request;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Request for /billiing/discount
 * @author ketul.shah
 *
 */
public class BillingDiscountRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
