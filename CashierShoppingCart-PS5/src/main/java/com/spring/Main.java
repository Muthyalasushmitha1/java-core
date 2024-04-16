package com.spring;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/spring/bean.xml");
        Cashier cashier = (Cashier) context.getBean("cashier");
        
        // Assume shopping cart is instantiated and available
        ShoppingCart cart = new ShoppingCart();
        // Add items to the shopping cart
        
        try {
            cashier.checkout(cart);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        context.close();
    }

}
