package GettingStartedBasics.patterns;

import java.util.Scanner;

/**
 * HelloWorld
 */
public class Pattern9 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        /// Taking user input
        int n = scn.nextInt();

        int sp = n / 2;
        int st = 1;
        //Always remember outer loop will represent the number of rows to be printed
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i == n - j + 1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("");
        }

    }
}