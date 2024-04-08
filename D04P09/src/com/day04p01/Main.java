package com.day04p01;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        // Pushing 4 elements
        stack.push("Hello");
        stack.push("world");
        stack.push("java");
        stack.push("Programming");

        System.out.print("After Pushing 4 Elements: ");
        stack.display();

        // Pop an element
        String poppedElement = stack.pop();
        System.out.println("After a Pop:" );
        stack.display();
    }
}

