package com.day01p02;

import java.util.Scanner;

public class ArrayComputation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] A = new int[18];

        System.out.println("Enter 18 integer values:");
        for (int i = 0; i < 18; i++) {
            A[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += A[i];
        }
        A[15] = sum;

        double average = (double) sum / 15;
        A[16] = (int) Math.round(average);

        int smallest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < smallest) {
                smallest = A[i];
            }
        }
        A[17] = smallest;

        System.out.println("Output:");
        for (int num : A) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
