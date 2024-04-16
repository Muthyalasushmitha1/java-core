package com.spring.dependencyinjection;

public class Disc extends Product {
    private String format;
//    private String productId;
//    private String productName;
//    private double price; 
    

	public Disc() {
		super();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	

	public String getProductId() {
		return super.getProductId();
	}

	public void setProductId(String productId) {
		super.setProductId(productId);
	}

	public String getProductName() {
		return super.getProductName();
	}

	public void setProductName(String productName) {
		super.setProductName(productName);
	}

	public double getPrice() {
		return super.getPrice();
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}
	


}