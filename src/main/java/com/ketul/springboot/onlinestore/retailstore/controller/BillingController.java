package com.ketul.springboot.onlinestore.retailstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ketul.springboot.onlinestore.retailstore.api.model.request.BillingDiscountRestRequest;
import com.ketul.springboot.onlinestore.retailstore.api.model.response.BillingDiscountResponse;
import com.ketul.springboot.onlinestore.retailstore.bl.model.request.BillingDiscountRequest;
import com.ketul.springboot.onlinestore.retailstore.service.IBillingService;

/**
 * 
 * @author ketul.shah
 *
 */
@RestController
@RequestMapping(value = "/billing")
public class BillingController {

	@Autowired
	IBillingService billingService;

	@Autowired
	private DozerBeanMapperFactoryBean dozerBean;

	@RequestMapping(value = "/payableamount/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Object> getPayableAmount(HttpServletRequest request,
			@RequestBody BillingDiscountRestRequest billingDiscountRestRequest, @PathVariable(name = "userId") Long userId) throws Exception {
		
        Mapper mapper =  dozerBean.getObject();

        BillingDiscountRequest billingDiscountRequest = new BillingDiscountRequest();
        mapper.map(billingDiscountRestRequest, billingDiscountRequest, "billingDiscount");
        
        Double payableAmount = billingService.getPayableAmount(billingDiscountRequest, userId);
        
        BillingDiscountResponse billingDiscountResponse = new BillingDiscountResponse();
        billingDiscountResponse.setPayableAmount(payableAmount);
		return new ResponseEntity<>(billingDiscountResponse, HttpStatus.OK);
	}
	
	

}
