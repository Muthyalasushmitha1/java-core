package com.day03p01;

import java.util.HashSet;

public class ProductHashSetExample {
    public static void main(String[] args) {
        // Create HashSet to store Product objects
        HashSet<Product> products = new HashSet<>();

        // Add predefined information of 4 products
        products.add(new Product("P001", "Maruti 800"));
        products.add(new Product("P002", "Maruti Zen"));
        products.add(new Product("P003", "Maruti Dezire"));
        products.add(new Product("P004", "Maruti Alto"));

        // List all the product details
        for (Product product : products) {
            System.out.println(product.getProductId() + " " + product.getProductName());
        }
    }
}