package com.bridgelabz;

import java.util.*;

public class PrimeNumbers {

    ArrayList<Integer> primes = new ArrayList<>();
    Set<Integer> anagramSet = new TreeSet<>();
    int row = 10, col = 25;
    int[][] array2D = new int[row][col];
    int[][] primeAnagramArray2D = new int[row][col];

    /**
     * Method for determining primes in the given range
     *
     * @param Range takes int the value upto which primeNumbers have to be printed
     */
    public void primeNumbers(int Range) {

        for (int i = 2; i <= Range; i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0 || i == 2) {
                primes.add(i);
            }
        }
        System.out.println("primes = " + primes);

        int n1 = 0, n2 = 100, i = 0, j = 0;
        for (int x : primes) {
            if (x >= n1 && x < n2 && n2 <= 1000) {
                array2D[i][j] = x;
                j++;
                if (isAnagramPrime(x)) {
                    anagramSet.add(x);
                }
            }
            if (x >= n2) {
                i++;
                j = 0;
                n1 += 100;
                n2 += 100;
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (array2D[r][c] != 0) {
                    System.out.print((array2D[r][c]) + "  ");
                }
            }
            System.out.println();
        }
    }

    public boolean isAnagramPrime(int x) {
        String newNum = "";

        if (x > 11) {
            String[] primeDigits = (Integer.toString(x).split(""));
            System.out.println("Before shuffle = " + x);
            Collections.shuffle(Arrays.asList(primeDigits));
            for (int i = 0; i < primeDigits.length; i++) {
                newNum += primeDigits[i];
            }
            int shuffledNum = Integer.parseInt(newNum);
            System.out.println(shuffledNum);
            while (shuffledNum == x) {
                shuffledNum = shuffleTheNumber(x);
                System.out.println(shuffledNum);
            }
            if (isPrime(shuffledNum)) {
                anagramSet.add(shuffledNum);
                return true;
            } else return false;
        }
        return false;
    }

    public int shuffleTheNumber(int x) {
        String newNum = "";
        if (x > 11) {
            String[] primeDigits = (Integer.toString(x).split(""));
            Collections.shuffle(Arrays.asList(primeDigits));
            for (int i = 0; i < primeDigits.length; i++) {
                newNum += primeDigits[i];
            }
            int shuffledNum = Integer.parseInt(newNum);
            return shuffledNum;
        }
        return x;
    }

    public boolean isPrime(int num) {
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else
            return false;
    }

    public void hashSetTo2DArray() {
        System.out.println("PrimeAnagrams in 2D Array = ");
        int n1 = 0, n2 = 100, i = 0, j = 0;
        for (int x : anagramSet) {
            if (x >= n1 && x < n2 && n2 <= 1000) {
                primeAnagramArray2D[i][j] = x;
                j++;
            }
            if (x >= n2) {
                i++;
                j = 0;
                n1 += 100;
                n2 += 100;
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (primeAnagramArray2D[r][c] != 0) {
                    System.out.print((primeAnagramArray2D[r][c]) + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrimeNumbers obj = new PrimeNumbers();
        obj.primeNumbers(1000);
        obj.hashSetTo2DArray();
    }
}
