package com.ketul.springboot.onlinestore.retailstore.api.model.request;

import java.text.ParseException;


/**
 * Interface to validate incoming requests via REST APIs.
 *
 */
public interface ValidateRequest {
	/**
	 * Validate request received via API.
	 * 
	 * @throws Exception
	 * @throws ParseException
	 */
	void validateRequest() throws Exception, ParseException;
}
