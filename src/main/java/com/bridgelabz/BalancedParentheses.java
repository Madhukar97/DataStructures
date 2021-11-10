package com.bridgelabz;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    /**
     * Method to check whether the expression is having balanced parentheses or not
     *
     * @return returns true if balanced and false if expression not balanced
     */
    public void balancedParentheses() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression");
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Expression is balanced");
        } else
            System.out.println("Expression is not balanced");
    }

    public static void main(String[] args) {
        BalancedParentheses obj = new BalancedParentheses();
        obj.balancedParentheses();
    }
}