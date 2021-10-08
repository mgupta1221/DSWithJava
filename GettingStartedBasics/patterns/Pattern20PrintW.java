package GettingStartedBasics.patterns;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=xvXhZ0k1fYo&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=74
 * Printing W
 * 
 */
public class Pattern20PrintW {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n) {
                    System.out.print("X");
                }
                // printing diagonal in second half- Notice the condition of both diagonals
                else if (i > (n / 2) && (i == j || i + j == n + 1)) {
                    System.out.print("X");

                } else {
                    System.out.print(" ");
                }

            }

            System.out.println("");
        }

    }
}
