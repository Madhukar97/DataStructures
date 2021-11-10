package com.bridgelabz;

import java.util.*;

public class PrimeNumbers {

    ArrayList<Integer> primes = new ArrayList<>();
    ArrayList<Integer> primeAnagrams = new ArrayList<>();
    Set<Integer> set = new TreeSet<>();
    int row = 10, col = 25;
    int[][] Array2D = new int[row][col];

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
        System.out.println("primes = "+primes);

        int n1 = 0, n2 = 100, i = 0, j = 0;
        for (int x : primes) {
            if (x >= n1 && x < n2 && n2 <= 1000 ) {
                Array2D[i][j] = x;
                j++;
                isAnagramPrime(x);
            }
            if (x >= n2) {
                i++;
                j = 0;
                n1 += 100;
                n2 += 100;
            }
        }
        System.out.println("primeAnagrams = "+primeAnagrams);
        for (int[] array : Array2D) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("AnagramSet = "+set);
    }

    public void isAnagramPrime(int x) {

        permutations("", Integer.toString(x));
    }


    public void permutations(String partial, String remaining) {

        // permutation case
        if (remaining.length() == 0) {
            int newNum = Integer.parseInt(partial);
            if (isPrime(newNum)) {
                set.add(newNum);
            }
        }
        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = partial + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permutations(newCandidate, newRemaining);
        }
    }

    public boolean isPrime(int num){
        int count=0;

        for(int i=2;i<num;i++){
            if (num%i==0){
                count++;
            }
        }
        if (count==0){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        PrimeNumbers obj = new PrimeNumbers();
        obj.primeNumbers(1000);

    }
}
