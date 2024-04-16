package com.spring.shopping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
 public static void main(String[] args) {
     // Load Spring application context from XML configuration file
     ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/shopping/Context.xml");

     ShoppingCart customer1Cart = (ShoppingCart) context.getBean("shoppingCart");
     customer1Cart.addProduct(new Product("Laptop", 12000.00));
     customer1Cart.addProduct(new Product("Phone", 8000.00));

     ShoppingCart customer2Cart = (ShoppingCart) context.getBean("shoppingCart");
     customer2Cart.addProduct(new Product("Tablet", 5000.00));
     customer2Cart.addProduct(new Product("samsungTv", 50000.00));


     // Display the contents of each customer's shopping cart
     System.out.println("1st Customer cart :");
     for (Product product : customer1Cart.getProducts()) {
         System.out.println(product.getName() + "- $" + product.getPrice());
     }

     System.out.println("2nd Customer Cart:");
     for (Product product : customer2Cart.getProducts()) {
         System.out.println(product.getName() + " - $" + product.getPrice());
     }
 }
}
