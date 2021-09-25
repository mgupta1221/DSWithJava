package patterns;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=y-b-8ddRFR4&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=70
 * 
 * 
 */
public class Pattern18 {

    public static void main(String[] args) {

        int n = 7;
        int sp = 0;
        int st = n;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= st; j++) {
                // Skipping stars in first half and printing space except first and last star of the row(condion for J below)
                if (i > 1 && i <= n / 2 && j > 1 && j < st) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");

                }

            }

            if (i <= n / 2) {
                sp++;
                st -= 2;

            } else {
                sp--;
                st += 2;
            }
            System.out.println("");
        }

    }
}
