package com.ketul.springboot.onlinestore.retailstore.constants;

public enum UserTypeEnum {
	STORE_EMPLOYEE("STORE_EMPLOYEE"), AFFILIATE("AFFILIATE"), CUSTOMER("CUSTOMER");

	private final String text;

	private UserTypeEnum(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
