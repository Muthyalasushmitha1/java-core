package com.day03p09;

import java.util.Hashtable;

public class Main {
	 public static void main(String[] args) {
	     Hashtable<Integer, Employee> employeeTable = new Hashtable<>();
	     employeeTable.put(101, new Employee(101, "John Doe", "IT", "Software Engineer"));
	     employeeTable.put(102, new Employee(102, "Jane Smith", "HR", "HR Manager"));
	     employeeTable.put(103, new Employee(103, "David Lee", "Finance", "Financial Analyst"));
	     employeeTable.put(104, new Employee(104, "Mary Johnson", "Operations", "Operations Manager"));
	     System.out.println("Is the Hashtable empty? " + employeeTable.isEmpty());
	 }
	}
