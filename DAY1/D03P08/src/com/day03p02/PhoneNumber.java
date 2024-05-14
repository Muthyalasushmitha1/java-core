package com.day03p02;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

    public static void main(String[] args) {
        // Create a HashMap to store phone book details
        Map<String, String> phoneBook = new HashMap<>();

        // Add predefined information of 5 phone book details
        phoneBook.put("Amal", "998787823");
        phoneBook.put("Manvitha", "937843978");
        phoneBook.put("Joseph", "7882221113");
        phoneBook.put("Smith", "8293893311");
        phoneBook.put("Kathe", "7234560011");

        // Name to search for
        String nameToSearch = "Joseph";

        // Search for the phone number by name
        if (phoneBook.containsKey(nameToSearch)) {
            String phoneNumber = phoneBook.get(nameToSearch);
            System.out.println("Phone Number for " + nameToSearch + ": " + phoneNumber);
        } else {
            System.out.println("Phone number not found for " + nameToSearch);
        }
    }
}
