package com.day04p02;

public class StackLinkedList{

class Node {
    double data;
    Node next;

    public Node(double data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(double data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public double pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return Double.NaN;
        }
        double poppedElement = top.data;
        top = top.next;
        return poppedElement;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("The elements of the stack are: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 
	
}
