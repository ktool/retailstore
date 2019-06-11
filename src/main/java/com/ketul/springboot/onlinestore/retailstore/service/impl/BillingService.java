package com.ketul.springboot.onlinestore.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ketul.springboot.onlinestore.retailstore.bl.model.request.BillingDiscountRequest;
import com.ketul.springboot.onlinestore.retailstore.bl.model.request.Product;
import com.ketul.springboot.onlinestore.retailstore.common.Utils;
import com.ketul.springboot.onlinestore.retailstore.constants.BillingConstants;
import com.ketul.springboot.onlinestore.retailstore.constants.ErrorConstants;
import com.ketul.springboot.onlinestore.retailstore.constants.ProductCategoryEnum;
import com.ketul.springboot.onlinestore.retailstore.constants.UserTypeEnum;
import com.ketul.springboot.onlinestore.retailstore.dao.UserRepository;
import com.ketul.springboot.onlinestore.retailstore.entity.User;
import com.ketul.springboot.onlinestore.retailstore.service.IBillingService;

@Service
public class BillingService implements IBillingService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Double getPayableAmount(BillingDiscountRequest billingDiscountRequest, Long userId) throws Exception {

		Double totalAmount = billingDiscountRequest.getProducts().stream().mapToDouble(e -> e.getPrice()).sum();
		Double eligibleAmount = this.getTotalEligibleAmountForDiscount(billingDiscountRequest.getProducts());

		// Get discount amount based on percentage and user type
		Double discountAmountByPercent = getDiscountByUserAndEligibleAmount(userId, eligibleAmount);

		// Get discount amount based on Total Eligible amount
		Double otherDiscount = Math.floor(eligibleAmount / BillingConstants.customerDiscountAmountThreshold) * BillingConstants.customerDiscountAmount;

		// Get and return maximum discount
		if (discountAmountByPercent > otherDiscount)
			return totalAmount - discountAmountByPercent;

		return totalAmount - otherDiscount;
	}

	@Override
	public Double getDiscountByUserAndEligibleAmount(Long userId, Double eligibleAmount) throws Exception {

		User user = this.findUserById(userId);
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorConstants.USER_DOES_NOT_EXISTS);
		}

		Double eligibleDiscountAmount = (double) 0;
		if (user.getUserType().equalsIgnoreCase(UserTypeEnum.STORE_EMPLOYEE.name())) {
			eligibleDiscountAmount = (eligibleAmount * BillingConstants.storeEmployeeDiscountPercent) / 100;

		} else if (user.getUserType().equalsIgnoreCase(UserTypeEnum.AFFILIATE.name())) {
			eligibleDiscountAmount = (eligibleAmount * BillingConstants.affiliateDiscountPercent) / 100;

		} else if (user.getUserType().equalsIgnoreCase(UserTypeEnum.CUSTOMER.name())) {

			int registerDuration = Utils.getUserRegisteredDurationInYear(user.getRegisteredDate());

			if (registerDuration >= 2)
				eligibleDiscountAmount = (eligibleAmount * BillingConstants.oldCustomerDiscountPercent) / 100;

		}

		return eligibleDiscountAmount;
	}

	@Override
	public Double getTotalEligibleAmountForDiscount(List<Product> products) {

		// TODO: Call product service to make sure all the product are valid from PRODUCT DB

		// Ignore if product category is Grocery
		return products.stream().filter(e -> !ProductCategoryEnum.GROCERY.name().equalsIgnoreCase(e.getCategory()))
				.mapToDouble(e -> e.getPrice()).sum();

	}

	@Override
	public User findUserById(Long userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User findByUserName(String name) {
		return userRepository.findByUserName(name);
	}

}
