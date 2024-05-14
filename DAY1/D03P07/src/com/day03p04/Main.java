package com.day03p04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> productHashSet = new HashSet<>();
 
        
        productHashSet.add(new Product("P001", "iPhone 13"));
        productHashSet.add(new Product("P002", "Samsung Galaxy S21"));
        productHashSet.add(new Product("P003", "Maruti Dezire"));
        productHashSet.add(new Product("P004", "Sony PlayStation 5"));
 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID to remove: ");
        String productIdToRemove = scanner.nextLine();
 
        
        boolean removed = false;
        Iterator<Product> iterator = productHashSet.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(productIdToRemove)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
 
       
        if (removed) {
            System.out.println("Product with ID " + productIdToRemove + " removed successfully.");
        } else {
            System.out.println("No product found with ID " + productIdToRemove + ".");
        }
 
       
        System.out.println("Remaining products:");
        for (Product product : productHashSet) {
            System.out.println(product.getProductId() + " " + product.getProductName());
        }
 
        scanner.close();
    }
}