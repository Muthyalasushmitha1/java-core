package com.day02p06;

public class LongestPrefixSuffix {
    public static int longestPrefixSuffixLength(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // Iterate through possible prefix lengths
        for (int i = 1; i <= n / 2; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(n - i);
            if (prefix.equals(suffix)) {
                maxLength = i;
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(longestPrefixSuffixLength("aabcdaabc")); 
        System.out.println(longestPrefixSuffixLength("abcab"));     
    }
}
