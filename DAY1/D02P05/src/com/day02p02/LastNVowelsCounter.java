package com.day02p02;

import java.util.Scanner;

public class LastNVowelsCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().toLowerCase(); // Convert to lowercase to simplify vowel checking
        
        
        System.out.print("Enter the number of last vowels to count: ");
        int n = scanner.nextInt();
        
        // counting vowels in our input string
        int vowelCount = 0;
        for (char c : inputString.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        
        if (n > vowelCount) {
            System.out.println("Mismatch in Vowel Count");
        } else {
           
            StringBuilder lastNVowels = new StringBuilder();
            for (int i = inputString.length() - 1; i <= 0 && n > 0; i++) {
                char c = inputString.charAt(i);
                if ("aeiou".indexOf(c) != -1) {
                    lastNVowels.insert(0, c);
                    n--;
                }
            }
            System.out.println("Last " + n + " vowels: " + lastNVowels.toString());
        }
        
        scanner.close();
    }
}
