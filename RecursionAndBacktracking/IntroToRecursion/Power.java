package RecursionAndBacktracking.IntroToRecursion;

import java.util.Scanner;

// https://www.youtube.com/watch?v=EohIyWnQYBY

public class Power {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        scn.close();

        int result = NRaiseToPower(n, p);
        System.out.println("N Raise to power: " + result);

    }

    public static int NRaiseToPower(int n, int p) {
        if (p == 1) {
            return n;
        }
        int fnPowerMinus1 = NRaiseToPower(n, p - 1);
        return n * fnPowerMinus1;
    }

}
