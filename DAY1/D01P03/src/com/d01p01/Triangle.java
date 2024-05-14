package com.d01p01;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();  
        for (int i = 1; i <= rows; i++) {
            
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            
            System.out.println();
        }
        scanner.close();
    }
}