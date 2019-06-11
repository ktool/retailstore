package com.ketul.springboot.onlinestore.retailstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ketul.springboot.onlinestore.retailstore.bl.model.request.BillingDiscountRequest;
import com.ketul.springboot.onlinestore.retailstore.bl.model.request.Product;
import com.ketul.springboot.onlinestore.retailstore.constants.BillingConstants;
import com.ketul.springboot.onlinestore.retailstore.dao.UserRepository;
import com.ketul.springboot.onlinestore.retailstore.entity.User;
import com.ketul.springboot.onlinestore.retailstore.service.impl.BillingService;

@RunWith(SpringRunner.class)
public class BillingServiceAffiliateUserIntegrationTest extends TestData {

	@Autowired
	BillingService billingService;

	@MockBean
	UserRepository userRepository;

	@TestConfiguration
	static class BillingServiceIntegrationTestContextConfiguration {
		@Bean
		public BillingService billingService() {
			return new BillingService();
		}
	}

	@Before
	public void setUp() {

		User user = new User("KetulAFFILIATECustomer", "AFFILIATE", new Date());
		user.setId(userId);
		when(userRepository.findByUserId(userId)).thenReturn(user);
	}

	@Test
	public void test_getTotalEligibleAmountForDiscount() {
		Double eligibleAmount = billingService.getTotalEligibleAmountForDiscount(products);
		assertThat(p1.getPrice() + p3.getPrice()).isEqualTo(eligibleAmount);
	}

	@Test
	public void test_getDiscountByUserAndEligibleAmount_ForAffilliateUser() throws Exception {

		Double eligibleAmount = billingService.getTotalEligibleAmountForDiscount(products);
		Double eligibleDiscount = (eligibleAmount * BillingConstants.affiliateDiscountPercent) / 100;
		// when
		User found = billingService.findUserById(userId);

		Double discount = billingService.getDiscountByUserAndEligibleAmount(found.getId(), eligibleAmount);
		assertThat(eligibleDiscount).isEqualTo(discount);
	}

	@Test
	public void test_getPayableAmount() throws Exception {

		BillingDiscountRequest billingDiscountRequest = new BillingDiscountRequest();
		billingDiscountRequest.setProducts(products);

		// when
		User found = billingService.findUserById(userId);

		Double eligibleAmount = billingService.getTotalEligibleAmountForDiscount(products);
		Double discount = billingService.getDiscountByUserAndEligibleAmount(found.getId(), eligibleAmount);

		Double payableAmount = billingService.getPayableAmount(billingDiscountRequest, found.getId());
		Double expected = products.stream().mapToDouble(e -> e.getPrice()).sum() - discount;
		assertThat(expected).isEqualTo(payableAmount);
	}
}
