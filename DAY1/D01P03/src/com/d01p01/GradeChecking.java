package com.d01p01;

import java.util.Scanner;

public class GradeChecking {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the percentage: ");
        int percentage = scanner.nextInt();
        
        char grade = calculateGrade(percentage);
        
        System.out.println("Grade: " + grade);
    }
    
    public static char calculateGrade(int percentage) {
        if (percentage >= 60) {
            return 'A';
        } else if (percentage >= 45) {
            return 'B';
        } else if (percentage >= 35) {
            return 'C';
        } else {
            return 'F'; // Fail
        }
    }
}
 