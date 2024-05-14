package com.day03p06;

import java.util.NavigableSet;
import java.util.TreeMap;

public class Main {
	 public static void main(String[] args) {
	     // Create a TreeMap to store Car details (automatically sorted by price)
	     TreeMap<Car, Double> carMap = new TreeMap<>();

	     // Add predefined information of 4 Car details to the TreeMap
	     carMap.put(new Car("Bugatti", 80050.0), 80050.0);
	     carMap.put(new Car("Swift", 305000.0), 305000.0);
	     carMap.put(new Car("Audi", 600100.0), 600100.0);
	     carMap.put(new Car("Benz", 900000.0), 900000.0);

	     // Retrieve and print car details sorted by price in reverse order
	     System.out.println(" Reverse Order of Car Details by price:");
	     NavigableSet<Car> reversedSet = carMap.descendingKeySet();
	     for (Car car : reversedSet) {
	         System.out.println(car);
	     }
	 }
	}