package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// https://www.youtube.com/watch?v=m4rdYPuisKc

public class Factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int result = Factorial(n);
        System.out.println("Factorial: " + result);        

    }

    public static int Factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int fnMinus1 = Factorial(n - 1);
        return n * fnMinus1;
    }

}
