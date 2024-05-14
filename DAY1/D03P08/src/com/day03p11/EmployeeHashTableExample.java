package com.day03p11;

import java.util.Hashtable;

public class EmployeeHashTableExample {
    public static void main(String[] args) {
        // Create a Hashtable to store Employee objects with id as key
        Hashtable<Integer, Employee> employeeTable = new Hashtable<>();

        // Predefined Employee details
        Employee[] employees = {
            new Employee(1001, "Daniel", "L&D", "Analyst"),
            new Employee(1002, "Thomas", "Testing", "Tester"),
            new Employee(1003, "Robert", "Development", "Product Manager"),
            new Employee(1004, "Grace", "HR", "Tech Support")
        };

        // Populate the Hashtable with predefined Employee objects
        for (Employee emp : employees) {
            employeeTable.put(emp.getId(), emp);
        }

        // Add new employee if not exists
        addEmployeeIfNotExists(employeeTable, 1005, "Charles", "Testing", "QA Lead");

        // Output all employees
        for (Employee emp : employeeTable.values()) {
            System.out.println(emp.toString() + " in java");
        }
    }

    // Method to add an employee if not already present
    private static void addEmployeeIfNotExists(Hashtable<Integer, Employee> table, int id,
                                               String name, String department, String designation) {
        if (!table.containsKey(id)) {
            Employee newEmployee = new Employee(id, name, department, designation);
            table.put(id, newEmployee);
        }
    }
}