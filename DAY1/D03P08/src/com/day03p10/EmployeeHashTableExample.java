package com.day03p10;

import java.util.Hashtable;

public class EmployeeHashTableExample {
    public static void main(String[] args) {
        // Create a Hashtable to store Employee objects with id as key
        Hashtable<Integer, Employee> employeeTable = new Hashtable<>();

        // Populate the Hashtable with predefined Employee details
        employeeTable.put(1001, new Employee(1001, "John", "HR", "HR Manager"));
        employeeTable.put(1002, new Employee(1002, "Alice", "Finance", "Finance Analyst"));
        employeeTable.put(1003, new Employee(1003, "Robert", "Development", "Product Manager"));
        employeeTable.put(1004, new Employee(1004, "Emma", "Marketing", "Marketing Manager"));

        // Perform a search operation for a specific Employee by id
        int searchId = 1003;
        Employee foundEmployee = employeeTable.get(searchId);

        // Output the details of the found Employee
        if (foundEmployee != null) {
            System.out.println(foundEmployee.toString() + " in java");
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }
    }
}