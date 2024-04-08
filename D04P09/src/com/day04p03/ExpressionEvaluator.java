package com.day04p03;

import java.util.Stack;

public class ExpressionEvaluator {
    
    
    public static int evaluateExpression(String expression) {

        expression = expression.replaceAll("\\s+", "");
        
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (Character.isDigit(ch)) {
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = operand * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                operandStack.push(operand);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    operandStack.push(applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operatorStack.empty() && hasPrecedence(ch, operatorStack.peek())) {
                    operandStack.push(applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(ch);
            }
        }
        
        while (!operatorStack.empty()) {
            operandStack.push(applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        
        return operandStack.pop();
    }
    
  
    public static int applyOperation(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
    
    
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }
    
    
    public static void main(String[] args) {
        String expression = "10 + 2 * 6";
        int result = evaluateExpression(expression);
        System.out.println("Output: " + result);
    }
}

