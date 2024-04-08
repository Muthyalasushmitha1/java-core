package com.day02p04;

public class MinDeletionsForPalindrome {

    // Function to find the minimum number of deletions to make a string palindrome
    static int minDeletionsToMakePalindrome(String str) {
        int n = str.length();
        // Initialize a 2D array to store the number of deletions needed to make substrings palindromic
        int[][] dp = new int[n][n];

        // Fill the dp array
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                // If the endpoints are equal, no deletions needed in this range
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // If the endpoints are different, we can either delete one character from the beginning or the end
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The minimum number of deletions to make the entire string palindrome is stored at dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String input = "aebcbda";
        System.out.println("Minimum deletions to make palindrome: " + minDeletionsToMakePalindrome(input));
    }
}
