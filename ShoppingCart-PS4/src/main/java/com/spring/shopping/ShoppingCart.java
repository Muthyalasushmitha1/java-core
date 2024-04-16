package com.spring.shopping;

import java.util.ArrayList;
import java.util.List;

//ShoppingCart.java
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
}

