package com.d01p01;

import java.util.Scanner;

public class WeekdayPrinter {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
for(int i=0;i<3;i++) {
        System.out.print("Enter the week number: ");
        int weekNumber = scanner.nextInt();
        
        if (weekNumber >= 1 && weekNumber <= 7) {
            String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            System.out.println(weekdays[weekNumber - 1] + ".");
        } else if (weekNumber < 1) {
            System.out.println("Invalid Input: Week number cannot be negative.");
        } else {
            System.out.println("Invalid Input: Week number should be between 1 and 7.");
        }
    }
    }
}