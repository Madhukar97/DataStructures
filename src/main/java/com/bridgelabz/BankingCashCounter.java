package com.bridgelabz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankingCashCounter {

    int amount = 100000;
    Queue<String> queue = new LinkedList<>();

    /**
     * Method to create a Queue
     */
    public void setQueue() {
        queue.offer("Person1");
        queue.offer("Person2");
        queue.offer("Person3");
        queue.offer("Person4");
        System.out.println(queue);
    }

    /**
     * Method for depositing or withdrawing money
     */
    public void inputPanel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(queue.peek());
        System.out.println("Enter 1 to deposit and 2 to withdrawal money");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                deposit();
                break;
            }
            case 2: {
                withdrawal();
                break;
            }
        }
    }

    /**
     * Method to deposit money
     */
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to be deposited: ");
        amount += scanner.nextInt();
        queue.remove();
    }

    /**
     * Method to withdrawal money
     */
    public void withdrawal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount for withdrawal: ");
        int withdrawal = scanner.nextInt();
        while (amount - withdrawal < 0) {
            System.out.println("Amount exceeded Balance, Enter valid amount");
            withdrawal = scanner.nextInt();
        }
        if (amount - withdrawal >= 0) {
            amount -= withdrawal;
            queue.remove();
        }
    }

    public static void main(String[] args) {

        BankingCashCounter obj = new BankingCashCounter();
        obj.setQueue();
        while (!obj.queue.isEmpty()) {
            obj.inputPanel();
        }
        System.out.println(obj.amount);
    }
}
