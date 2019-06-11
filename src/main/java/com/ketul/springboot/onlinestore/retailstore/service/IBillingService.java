package com.ketul.springboot.onlinestore.retailstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ketul.springboot.onlinestore.retailstore.bl.model.request.BillingDiscountRequest;
import com.ketul.springboot.onlinestore.retailstore.bl.model.request.Product;
import com.ketul.springboot.onlinestore.retailstore.entity.User;

/**
 * Interface for creating
 * @author ketul.shah
 *
 */
public interface IBillingService {


	/**
	 * Service to get total eligible amount based on products (category)
	 * Need to IGNORE "GROCERY" from eligible product	 * 
	 * @param products
	 * @return
	 */
	Double getTotalEligibleAmountForDiscount(List<Product> products) throws Exception;

	/**
	 * Get Discount for a user based on total amount
	 * @param userId
	 * @param eligibleAmount
	 * @return
	 * @throws Exception
	 */
	Double getDiscountByUserAndEligibleAmount(Long userId, Double eligibleAmount) throws Exception;

	/**
	 * Service to get payable amount after discounts 
	 * @param billingDiscountRequest
	 * @param userTypeId 
	 * @return
	 * @throws Exception 
	 */
	Double getPayableAmount(BillingDiscountRequest billingDiscountRequest, Long userId) throws Exception;

	User findUserById(Long userId);

	User findByUserName(String name);

	
}
