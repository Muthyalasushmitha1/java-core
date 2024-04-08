package com.day03p09;

import java.util.Hashtable;

//Employee class representing details of an employee
class Employee {
 private int id;
 private String name;
 private String department;
 private String designation;

 // Constructor
 public Employee(int id, String name, String department, String designation) {
     this.id = id;
     this.name = name;
     this.department = department;
     this.designation = designation;
 }

 // Getter methods
 public int getId() {
     return id;
 }

 // Implementing toString method
 @Override
 public String toString() {
     return "Employee ID: " + id + ", Name: " + name + ", Department: " + department + ", Designation: " + designation;
 }

 // Implementing equals method (based on employee ID)
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (!(obj instanceof Employee)) return false;
     Employee other = (Employee) obj;
     return this.id == other.id;
 }

 // Implementing hashCode method (based on employee ID)
 @Override
 public int hashCode() {
     return Integer.hashCode(id);
 }
}

