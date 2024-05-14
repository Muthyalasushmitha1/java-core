package com.day03p01;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String[] args) {
        
        Map<String, String> phoneBook = new HashMap<>();  
        phoneBook.put("Amal", "998787823");
        phoneBook.put("Manvitha", "937843978");
        phoneBook.put("Joseph", "7882221113");
        phoneBook.put("Smith", "8293893311");
        phoneBook.put("Kathe", "7234560011");
    
        System.out.println("Phone Book Details:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            String phoneNumber = entry.getValue();
            System.out.println(name + " " + phoneNumber);
        }
    }
}
