package com.spring.ConstructorMethod;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring configuration file
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/ConstructorMethod/constructermethod.xml");

        // Get beans from the container
        Product battery = context.getBean("battery", Product.class);
        Product disc = context.getBean("disc", Product.class);

        // Print out the beans
        System.out.println("Battery: " + battery);
        battery.toString();
        System.out.println("Disc: " + disc);
        disc.toString();

        // Close the context
        context.close();
    }
}

