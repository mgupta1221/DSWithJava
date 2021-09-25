package patterns;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=SHaqp8vqzxg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=72
 * Printing Swastik
 * 
 */
public class Pattern19 {

    public static void main(String[] args) {

        int n = 7;
        int sp = 0;
        int st = n;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1) {
                    if (j <= n / 2 + 1 || j == n) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                } else if (i <= n / 2) {
                    if (j == n / 2 + 1 || j == n) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                } else if (i == n / 2 + 1) {
                    System.out.print("*");

                } else if (i > n / 2 + 1 && i < n) {
                    if (j == n / 2 + 1 || j == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                } else if (i == n) {
                    if (j == 1 || j > n / 2 + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

            }

            System.out.println("");
        }

    }
}
