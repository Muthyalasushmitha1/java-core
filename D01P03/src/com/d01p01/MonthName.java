package com.d01p01;

import java.util.Scanner;

public class MonthName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) { // Loop to repeat 3 times
            System.out.print("Enter a number between 1 and 12: ");
            int monthNum = scanner.nextInt();
 
            String[] months = {
                    "January", "February", "March", "April",
                    "May", "June", "July", "August",
                    "September", "October", "November", "December"
            };
 
            if (monthNum >= 1 && monthNum <= 12) {
                System.out.println(months[monthNum - 1]);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
 
