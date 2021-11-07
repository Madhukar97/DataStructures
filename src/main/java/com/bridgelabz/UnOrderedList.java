package com.bridgelabz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Scanner;

public class UnOrderedList<T> {

    String[] array;
    String inputText;
    LinkedList<T> linkedList = new LinkedList<T>();

    public static void main(String[] args) throws FileNotFoundException {

        UnOrderedList<String> obj = new UnOrderedList<>();
        obj.readFromFile();
        obj.readInputFromUser();
        obj.compareText();
        obj.saveToFile();
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File("G:\\programming\\JAVA LFP batch\\DataStructures\\sampleText.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            array = sc.nextLine().split(" ");
        }
        for (String item : array) {
            linkedList.add((T) item);
        }
        System.out.println(linkedList);
    }

    public void readInputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to compare with file: ");
        inputText = sc.nextLine();
    }

    public void compareText() {
        if (linkedList.contains(inputText)) {
            linkedList.remove(inputText);
        } else if (!linkedList.contains(inputText)) {
            linkedList.add((T) inputText);
        }
    }

    public void saveToFile() {
        String contents = new String();
        for (T item : linkedList) {
            contents += item+" ";
        }
        try {
            Files.writeString(Path.of("G:\\programming\\JAVA LFP batch\\DataStructures\\sampleText.txt"), contents, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            // Handle exception
        }
    }
}
