package com.day04p02;

import com.day04p02.StackLinkedList;
import com.day04p02.StackLinkedList.Stack;

public class Main {
    public static void main(String[] args) {
    	StackLinkedList stack = new StackLinkedList();

        stack.push(10.0);
        stack.push(20.0);
        stack.push(30.0);
        stack.push(40.0);

        System.out.print("The elements of the stack are: ");
        stack.display();       
        stack.pop();
        stack.pop();

        System.out.print("After popping twice: ");
        stack.display();
    }
}

