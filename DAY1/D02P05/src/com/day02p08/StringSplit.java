package com.day02p08;

import java.util.HashSet;
import java.util.Set;

public class StringSplit {
	 
	public static void main(String[] args) {
 
        String input1 = "HELLOWORLD";
 
        System.out.println("Input 1: " + input1);
 
        System.out.println("Output 1: " + (canSplitIntoFourDistinctStrings(input1) ? "Yes" : "No"));
 
 
        String input2 = "aaabb";
 
        System.out.println("Input 2: " + input2);
 
        System.out.println("Output 2: " + (canSplitIntoFourDistinctStrings(input2) ? "Yes" : "No"));
 
    }
 
 
    public static boolean canSplitIntoFourDistinctStrings(String input) {
 
        if (input.length() < 4) {
 
            return false;
 
        }
 
 
        for (int i = 1; i < input.length(); i++) {
 
            for (int j = i + 1; j < input.length(); j++) {
 
                for (int k = j + 1; k < input.length(); k++) {
 
                    Set<Character> set = new HashSet<>();
 
                    set.add(input.charAt(0));
 
                    set.add(input.charAt(i));
 
                    set.add(input.charAt(j));
 
                    set.add(input.charAt(k));
 
                    if (set.size() == 4) {
 
                        return true;
 
                    }
 
                }
 
            }
 
        }
 
 
        return false;
 
    }
 
}