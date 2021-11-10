package com.bridgelabz;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {

    Deque<String> deque = new ArrayDeque<>();

    /**
     * Method to check if Palindrome using Deque
     */
    public void checkPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = scanner.next();
        String[] array = inputString.split("");
        for (String s : array) {
            deque.addFirst(s);
        }
        if (Arrays.toString(array).equals(deque.toString())) {
            System.out.println("Entered string is a palindrome");
        } else
            System.out.println("Entered string is not a palindrome");
    }

    public static void main(String[] args) {

        PalindromeChecker obj = new PalindromeChecker();
        obj.checkPalindrome();
    }
}
