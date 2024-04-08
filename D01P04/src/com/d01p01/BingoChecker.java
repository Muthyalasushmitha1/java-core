package com.d01p01;

import java.util.Scanner;

public class BingoChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two numbers in the range from 1 to 40:");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        int[] array = {7, 25, 5, 19, 30};

        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number1) {
                found1 = true;
            }
            if (array[i] == number2) {
                found2 = true;
            }
        }

        // Displaying the appropriate message
        if (found1 && found2) {
            System.out.println("Its Bingo");
        } else {
            System.out.println("Not Found");
        }

        scanner.close();
    }
}
