package com.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.shopping.Product;

public class ShoppingCart {
	

	private List<Product> products = new ArrayList<>();

	 public void addProduct(Product product) {
	     products.add(product);
	 }

	 public void removeProduct(Product product) {
	     products.remove(product);
	 }

	 public List<Product> getProducts() {
	     return products;
	 }

	public Date getItems() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "ShoppingCart [products=" + products + "]";
	}

}
