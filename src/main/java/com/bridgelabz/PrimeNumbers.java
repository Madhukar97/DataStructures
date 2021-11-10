package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbers {

    /**
     * Method for determining primes in the given range
     *
     * @param Range takes int the value upto which primeNumbers have to be printed
     */
    public void primeNumbers(int Range) {

        int row = 10, col = 25;
        ArrayList<Integer> primes = new ArrayList<>();
        int[][] Array2D = new int[row][col];

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

        int n1 = 0, n2 = 100, i = 0, j = 0;
        for (int x : primes) {
            if (x >= n1 && x < n2 && n2 <= 1000) {
                Array2D[i][j] = x;
                j++;
            }
            if (x >= n2) {
                i++;
                j = 0;
                n1 += 100;
                n2 += 100;

            }
        }
        for (int[] array : Array2D) {
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        PrimeNumbers obj = new PrimeNumbers();
        obj.primeNumbers(1000);
    }
}
