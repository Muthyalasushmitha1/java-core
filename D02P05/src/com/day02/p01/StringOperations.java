package com.day02.p01;

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input string
        System.out.print("Enter a string: ");
        String inputString = scanner.next();
        
        // Displaying length of the string
        System.out.println("Length of the inputstring: " + inputString.length());
        
        // Converting string to uppercase
        String uppercaseString = inputString.toUpperCase();
        System.out.println("Uppercase inputstring: " + uppercaseString);
        
        // Checking if the string is a palindrome
        boolean isPalindrome = checkPalindrome(inputString);
        if (isPalindrome) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }
        
        scanner.close();
    }
    
    // Function to check if a string is palindrome
    public static boolean checkPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
