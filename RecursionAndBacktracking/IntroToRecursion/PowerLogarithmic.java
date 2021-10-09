package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// https://www.youtube.com/watch?v=O84uumjBOMY

// Formula:
// Logartithmic way to find N Raise to Power : 
// if Power is Even N^p/2 * N^p/2               e.g. 2^8 = 2^4 * 2^4
// if Power is Odd  N^p/2 * N^p/2 * N           e.g. 2^7 = 2^3 * 2^3 * 2

public class PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        scn.close();

        int result = PowerLogarithmic(n, p);
        System.out.println("Factorial: " + result);

    }

    public static int PowerLogarithmic(int n, int p) {
        if (p == 1) {
            return n;
        }
        if (p % 2 == 0) {
            return PowerLogarithmic(n, p / 2) * PowerLogarithmic(n, p / 2);
        } else {
            return PowerLogarithmic(n, p / 2) * PowerLogarithmic(n, p / 2) * n;
        }
    }

}
