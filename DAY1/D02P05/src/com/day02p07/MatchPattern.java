package com.day02p07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchPattern {


    
    private static String getPattern(String word) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder patternBuilder = new StringBuilder();
        int patternNumber = 0;
        for (char ch : word.toCharArray()) {
            map.putIfAbsent(ch, patternNumber++);
            patternBuilder.append(map.get(ch));
        }
        return patternBuilder.toString();
    }

    
    public static List<String> findMatchingWords(List<String> dictionary, String pattern) {
        List<String> matchingWords = new ArrayList<>();
        String patternForm = getPattern(pattern);
        for (String word : dictionary) {
            if (word.length() == pattern.length() && getPattern(word).equals(patternForm)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    public static void main(String[] args) {
        List<String> dictionary = List.of("abc", "deq", "xyy", "abb", "dkd", "ccc");
        String pattern = "abb";
        List<String> matchingWords = findMatchingWords(dictionary, pattern);
        System.out.println("Words matching pattern \"" + pattern + "\": " + matchingWords);
    }
}

