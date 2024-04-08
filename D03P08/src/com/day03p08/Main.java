package com.day03p08;

import java.util.Map;
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

        // Print all car details before performing operations
        System.out.println("Car Details:");
        for (Car car : carMap.keySet()) {
            System.out.println(car);
        }

        // Remove and retrieve the key-value mapping associated with the greatest key (highest price)
        Map.Entry<Car, Double> entryWithGreatestPrice = carMap.lastEntry();
        System.out.println("\nCar with the Greatest Price:");
        System.out.println(entryWithGreatestPrice.getKey());
        carMap.remove(entryWithGreatestPrice.getKey());

        // Replace the value mapped by the specified key
        double newPrice = 80050.0;
        carMap.put(new Car("Reva", newPrice), newPrice);

        // Print all car details after performing operations
        System.out.println("\nCar Details After Operations:");
        for (Car car : carMap.keySet()) {
            System.out.println(car);
        }
    }
}
