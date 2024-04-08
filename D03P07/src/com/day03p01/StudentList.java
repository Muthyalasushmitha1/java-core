package com.day03p01;

import java.util.ArrayList;

public class StudentList {
    public static void main(String[] args) {
        // Create an ArrayList to store student names
        ArrayList<String> studentNames = new ArrayList<>();

        // Add student names to the list
        studentNames.add("Jack");
        studentNames.add("Paul");
        studentNames.add("Henry");
        studentNames.add("Mary");
        studentNames.add("Ronaldo");

        // Name to search for
        String nameToFind = "Henry";

        // Check if the name exists in the list
        boolean found = studentNames.contains(nameToFind);

        // Print the result
        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
