package com.d01p04;

import java.util.Scanner;

public class ArraySumLogic {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int[] A = new int[18];
        // Accept input for the array
        System.out.println("list of 18 elements:");
        for (int i = 0; i < 18; i++) {
            A[i] = scanner.nextInt();
        }
 
        // Compute the sum of elements from index 0 to 14 and store it at element 15
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += A[i];
        }
        A[15] = sum;
 
        // Compute the average of all numbers and store it at element 16
        double average = (double) sum / 18;
        A[16] = (int) Math.round(average);
 
        // Identify the smallest value from the array and store it at element 17
        int smallest = A[0];
        for (int i = 1; i < 18; i++) {
            if (A[i] < smallest) {
                smallest = A[i];
            }
        }
        A[17] = smallest;
 
        // Display the modified array
        for (int i = 0; i < 18; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
 
 
 
