package patterns;

//import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=Yqq4GUPvWQM&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=56
 */
public class Pattern11 {

    public static void main(String[] args) {
       // Scanner scn = new Scanner(System.in);
        /// Taking user input
        int n = 10;
        int val = 1;

        for (int i = 1; i <= n / 2 - 1; i++) {
            // printing space and X horizontally in each row
            for (int j = 1; j <= i; j++) {
                System.out.print(val + " ");
                val++;
            }
            System.out.println("");
        }

    }
}