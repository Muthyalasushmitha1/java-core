package com.day04p01;

class Stack {
    private int maxSize;
    private String[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new String[maxSize];
        this.top = -1;
    }

    public void push(String element) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        top++;
        stackArray[top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
        String poppedElement = stackArray[top];
        top--;
        return poppedElement;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
//        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}

