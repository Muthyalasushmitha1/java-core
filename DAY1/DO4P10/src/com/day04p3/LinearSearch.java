package com.day04p3;

import java.util.Scanner;

public class LinearSearch {
    
    // Function to perform linear search
    public static boolean linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
    
    // Main method to test the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the element to search: ");
        int key = scanner.nextInt();
        
        System.out.println("Input:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        boolean found = linearSearch(arr, key);
        
        if (found) {
            System.out.println("Output:");
            System.out.println("Element is Present");
        } else {
            System.out.println("Output:");
            System.out.println("Element is not Present");
        }
        
        scanner.close();
    }
}
