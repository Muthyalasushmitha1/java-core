
package com.day02p05; 
import java.util.*;

public class ChainedString {

    static boolean canFormCircle(String[] strings) {
        Map<Character, List<String>> graph = new HashMap<>();

        // Build a graph where each character points to the list of strings that start with it
        for (String str : strings) {
            char firstChar = str.charAt(0);
            char lastChar = str.charAt(str.length() - 1);

            graph.putIfAbsent(firstChar, new ArrayList<>());
            graph.get(firstChar).add(str);
        }

        // Perform DFS to check if a cycle exists
        for (String str : strings) {
            if (dfs(str, graph, new HashSet<>(), str.charAt(0))) {
                return true;
            }
        }

        return false;
    }

    static boolean dfs(String current, Map<Character, List<String>> graph, Set<String> visited, char start) {
        char lastChar = current.charAt(current.length() - 1);

        if (visited.contains(current)) {
            return lastChar == start; // Return true if we have reached the starting string again
        }

        visited.add(current);

        if (!graph.containsKey(lastChar)) {
            return false;
        }

        for (String next : graph.get(lastChar)) {
            if (dfs(next, graph, visited, start)) {
                return true;
            }
        }

        visited.remove(current);
        return false;
    }

    public static void main(String[] args) {
        String[] input1 = {"abc", "efg", "cde", "ghi", "ija"};
        System.out.println("Output for input1: " + (canFormCircle(input1) ? "Yes" : "No"));

        String[] input2 = {"Ijk", "kji", "abc", "cba"};
        System.out.println("Output for input2: " + (canFormCircle(input2) ? "Yes" : "No"));
    }
}
