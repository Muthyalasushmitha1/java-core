package com.d01p04;

import java.util.Scanner;

public class ArrayIndex {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Read the size of the array
	        int N = scanner.nextInt();
	        
	        // Create an array of size N
	        int[] arr = new int[N];
	        
	        // Read the elements of the array
	        for (int i = 0; i < N; i++) {
	            arr[i] = scanner.nextInt();
	        }
	        
	        // Initialize the index of the first repeating element to -1
	        int firstRepeatingIndex = -1;
	        
	        // Traverse the array
	        for (int i = 0; i < N; i++) {
	            // Check if the current element is repeating
	            for (int j = 0; j < i; j++) {
	                if (arr[j] == arr[i]) {
	                    firstRepeatingIndex = i;
	                    break;
	                }
	            }
	            // If repeating element found, break out of the loop
	            if (firstRepeatingIndex != -1) {
	                break;
	            }
	        }
	        
	        // Print the index of the first repeating element
	        System.out.println(firstRepeatingIndex == -1 ? "No repeating element found" : firstRepeatingIndex);
	    }
	
}
 