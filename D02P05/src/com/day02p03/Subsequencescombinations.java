package com.day02p03;

import java.util.Scanner;

public class Subsequencescombinations {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();
	        
	        // Print subsequences
	        System.out.println("Subsequences of '" + input + "':");
	        printSubsequences(input);
	        
	        scanner.close();
	    }
	    
	    public static void printSubsequences(String str) {
	        printSubsequencesHelper(str, "", 0);
	    }
	    
	    public static void printSubsequencesHelper(String input, String output, int index) {
	        if (index == input.length()) {
	            System.out.print(output + ", ");
	            return;
	        }
	        
	        printSubsequencesHelper(input, output, index + 1);
	        
	        printSubsequencesHelper(input, output + input.charAt(index), index + 1);
	    }
	}