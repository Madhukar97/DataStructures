package com.bridgelabz;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Calender {
    String[][] calendar = new String[6][7];
    private String month;

    /**
     * Method for setting up the calendar layout
     */
    public void calendarLayout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Month : ");
        month = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter year : ");
        int year = sc.nextInt();
        System.out.println("\n % Java Calendar " + month + " " + year + "\n");
        String weekName = "S\t" + "M\t" + "T\t" + "W\t" + "Th\t" + "F\t" + "S\t";
        System.out.println(weekName);
    }

    /**
     * Method for printing the calendar
     */
    public void printCalender() {
        Random r = new Random();
        int dayCount = 1;
        int numberOfDays;
        if (month.equals("january") || month.equals("march") || month.equals("may") ||
                month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december")) {
            numberOfDays = 31;
        } else if (month.equals("february")) {
            numberOfDays = 28;
        } else numberOfDays = 30;
        int random = r.nextInt(7);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayCount <= numberOfDays) {
                    if (random-- > 0) {
                        calendar[i][j] = " ";
                    } else {
                        calendar[i][j] = Integer.toString(dayCount);
                        dayCount++;
                    }
                    System.out.print(calendar[i][j] + "\t");
                    if (j == 6) System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Calender cal = new Calender();
        cal.calendarLayout();
        cal.printCalender();
    }
}