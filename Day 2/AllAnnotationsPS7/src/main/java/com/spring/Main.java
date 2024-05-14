package com.spring;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cashier cashier = context.getBean(Cashier.class);

        // Assume cart is instantiated and available
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("platinum");
        cart.addItem("diamonds");

        try {
            cashier.openFile();
            cashier.checkout(cart);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cashier.closeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        context.close();
    }
}
