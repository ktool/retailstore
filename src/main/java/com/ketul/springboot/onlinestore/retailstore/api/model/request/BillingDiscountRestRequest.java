package com.ketul.springboot.onlinestore.retailstore.api.model.request;

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
public class BillingDiscountRestRequest implements ValidateRequest, Serializable {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public void validateRequest() throws Exception, ParseException {
		// TODO Auto-generated method stub
	}

}
