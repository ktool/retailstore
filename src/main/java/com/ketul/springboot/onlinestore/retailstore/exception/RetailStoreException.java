package com.ketul.springboot.onlinestore.retailstore.exception;

import org.springframework.http.HttpStatus;

public class RetailStoreException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	private HttpStatus status;

	public RetailStoreException(String userDoesNotExists, String errorMessage, HttpStatus status) {
		super();
		this.errorCode = userDoesNotExists;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RetailStoreException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", status=" + status
				+ "]";
	}

}
