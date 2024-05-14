package com.day02p09;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String input = "Mr John Smith";
        String replaced = replaceSpaces(input);
        System.out.println(replaced);
    }

    public static String replaceSpaces(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
