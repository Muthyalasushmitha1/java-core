package com.spring.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/dependencyinjection/settermethod.xml");

        // Retrieve the beans
        Battery battery = (Battery) context.getBean("battery");
        Disc disc = (Disc) context.getBean("disc");

        // Print the beans
//      System.out.println("Battery: " + battery);
        System.out.println("productid:"+battery.getProductId()+" productname:"+battery.getProductName()+" productprice:"+battery.getPrice()+" capacity:"+battery.getCapacity());
//        System.out.println("Disc: " + disc);
        System.out.println("productid:"+disc.getProductId()+" productname:"+disc.getProductName()+" productprice:"+disc.getPrice()+" format:"+disc.getFormat());


    }
}
