package com.bridgelabz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class OrderedList<T> {
    String[] array;
    Integer[] intArray;
    Integer inputNumber;

    LinkedList<T> linkedList = new LinkedList<T>();
    LinkedList<T> linkedListUpdated = new LinkedList<T>();

    public static void main(String[] args) throws FileNotFoundException {

        OrderedList<Integer> obj = new OrderedList<>();
        obj.readFromFile();
        obj.readInputFromUser();
        obj.compareText();
        obj.reSortingLinkedList();
        obj.saveToFile();
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File("G:\\programming\\JAVA LFP batch\\DataStructures\\ListOfNumbers.txt");
        Scanner sc = new Scanner(file);
        array = sc.nextLine().split(" ");
        stringToIntegerArray(array);

        for (Integer item : intArray) {
            linkedList.add((T) item);
        }
        System.out.println("Linked list is : " + linkedList);
    }

    public void readInputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to compare with file: ");
        inputNumber = sc.nextInt();
    }

    public void compareText() {
        if (linkedList.contains(inputNumber)) {
            linkedList.remove(inputNumber);
        } else if (!linkedList.contains(inputNumber)) {
            linkedList.add((T) inputNumber);
        }
        System.out.println(linkedList);
    }

    public void reSortingLinkedList() {
        Integer[] array = new Integer[linkedList.size()];
        int i = 0;
        for (T item : linkedList) {
            array[i] = (Integer) item;
            i++;
        }
        Arrays.sort(array);

        for (Integer item : array) {
            linkedListUpdated.add((T) item);
        }
        System.out.println("Linked list after resorting: " + linkedListUpdated);
    }

    public void stringToIntegerArray(String[] array) {
        intArray = new Integer[array.length];
        int i = 0;
        for (String s : array) {
            intArray[i] = Integer.parseInt(s);
            i++;
        }
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    public void saveToFile() {
        String contents = new String();
        for (T item : linkedListUpdated) {
            contents += item + " ";
        }
        try {
            Files.writeString(Path.of("G:\\programming\\JAVA LFP batch\\DataStructures\\ListOfNumbers.txt"), contents, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            // Handle exception
        }
    }
}