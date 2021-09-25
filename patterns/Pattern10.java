package patterns;

import java.util.Scanner;

/**
 * HelloWorld
 */
public class Pattern10 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        /// Taking user input
        int n = scn.nextInt();

        int st = 1;
        int outerSpace = n / 2;
        int innerSpace = -1;
        for (int i = 1; i <= n; i++) {
            // printing space and X horizontally in each row
            for (int j = 1; j <= outerSpace; j++) {
                System.out.print(" ");
            }

            System.out.print("X");

            // innerSpace will increase each time by 2 after row 1
            for (int j = 1; j <= innerSpace; j++) {
                System.out.print(" ");
            }

            // second star in the row should only be printed only if there are innerSpace
            if (innerSpace > -1) {
                System.out.print("X");
            }
            if (i <= n / 2) {
                outerSpace--;
                innerSpace += 2;

            } else {
                outerSpace++;
                innerSpace -= 2;
            }
            System.out.println("");
        }

    }
}