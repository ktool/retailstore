package com.ketul.springboot.onlinestore.retailstore.constants;

public enum ProductCategoryEnum {
	GROCERY("GROCERY"), CLOTH("CLOTH"), TOY("TOY");

	private final String text;

    private ProductCategoryEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
