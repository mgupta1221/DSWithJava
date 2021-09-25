package patterns;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=lKhGlVXdD2c&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=64
 * 
 */
public class Pattern15 {

    public static void main(String[] args) {

        int n = 5;
        int sp = n / 2;
        int st = 1;
        int temp = 1;
        int tempForRow = 1;
        // Always remember outer loop will represent the number of rows to be printed
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }

            tempForRow = temp;
            for (int j = 1; j <= st; j++) {
                System.out.print(tempForRow);
                if (j <= st / 2) {
                    tempForRow++;
                } else {
                    tempForRow--;
                }
            }

            if (i <= n / 2) {
                sp--;
                st += 2;
                temp++;

            } else {
                sp++;
                st -= 2;
                temp--;
            }
            System.out.println("");
        }

    }
}
