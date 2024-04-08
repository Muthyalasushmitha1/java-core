package com.day03p03;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> productHashSet = new HashSet<>();
 
        
        productHashSet.add(new Product("P001", "iPhone 13"));
        productHashSet.add(new Product("P002", "Samsung Galaxy S21"));
        productHashSet.add(new Product("P003", "Maruti Dezire"));
        productHashSet.add(new Product("P004", "Sony PlayStation 5"));
 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID and name (e.g., P003 Maruti Dezire): ");
        String searchInput = scanner.nextLine();
 
        
        String[] inputParts = searchInput.split(" ", 2); // Limit to 2 to avoid splitting productName with spaces
        String searchProductId = inputParts[0];
        String searchProductName = inputParts[1];
 
        
        Product searchProduct = new Product(searchProductId, searchProductName);
 
        boolean productFound = false;
        for (Product product : productHashSet) {
            if (product.equals(searchProduct)) {
                productFound = true;
                break;
            }
        }
 
        if (productFound) {
            System.out.println("Product Found");
        } else {
            System.out.println("Product Not Found");
        }
 
        scanner.close();
    }
}
