package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// https://www.youtube.com/watch?v=5Q5ed7PWJ8I&t=4s

public class PrintDecreasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);

    }

    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);

    }


}
