package com.day03p07;

import java.util.Map;
import java.util.TreeMap;

public class Main {
	 public static void main(String[] args) {
	    
	     TreeMap<Car, Double> carMap = new TreeMap<>();

	     
	     carMap.put(new Car("Bugatti", 80050.0), 80050.0);
	     carMap.put(new Car("Swift", 305000.0), 305000.0);
	     carMap.put(new Car("Audi", 600100.0), 600100.0);
	     carMap.put(new Car("Benz", 900000.0), 900000.0);

	     
	     Map.Entry<Car, Double> entryWithLeastPrice = carMap.firstEntry();
	     System.out.println("Car with the Least Price:");
	     System.out.println(entryWithLeastPrice.getKey());

	     
	     Map.Entry<Car, Double> entryWithGreatestPrice = carMap.lastEntry();
	     System.out.println("Car with the Greatest Price:");
	     System.out.println(entryWithGreatestPrice.getKey());
	 }
	}
