package GettingStartedBasics.patterns;

import java.util.Scanner;

/**
 * HelloWorld
 */
public class Pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        /// Taking user input
        int n = scn.nextInt();

        int sp = n / 2;
        int st = 1;
        // Always remmeber outer loop will represent the number of rows to be printed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < st; j++) {
                System.out.print("X");
            }
            if (i < n / 2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
            System.out.println("");
        }

    }
}