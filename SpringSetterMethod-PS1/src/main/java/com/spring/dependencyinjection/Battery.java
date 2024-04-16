package com.spring.dependencyinjection;

public class Battery extends Product {
    private int capacity;
//    private String productId;
//    private String productName;
//    private double price;
//    
    public Battery() {
    	
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

	public int getCapacity() {
		return capacity;
	}

    public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}


