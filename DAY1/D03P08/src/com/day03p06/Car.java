package com.day03p06;

import java.util.*;

//Car class representing details of a car
class Car implements Comparable<Car> {
 private String name;
 private double price;

 // Constructor
 public Car(String name, double price) {
     this.name = name;
     this.price = price;
 }

 // Getter methods
 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

 // Implementing toString method
 @Override
 public String toString() {
     return name + " " + price;
 }

 // Implementing equals method
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (!(obj instanceof Car)) return false;
     Car other = (Car) obj;
     return this.name.equals(other.name) && Double.compare(this.price, other.price) == 0;
 }

 // Implementing hashCode method
 @Override
 public int hashCode() {
     return Objects.hash(name, price);
 }

 // Implementing compareTo method for natural ordering based on price
 @Override
 public int compareTo(Car other) {
     return Double.compare(this.price, other.price);
 }
}


