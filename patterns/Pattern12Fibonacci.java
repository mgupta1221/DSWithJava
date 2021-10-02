package patterns;

//import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=Yqq4GUPvWQM&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=56
 */
public class Pattern12Fibonacci {

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        /// Taking user input
        int n = 10;
        int a = 0;
        int b = 1;
        int c;

        //Always remember outer loop will represent the number of rows to be printed
        for (int i = 0; i < n / 2 - 1; i++) {

            // Logic for Fibonacci
            for (int j = 0; j <= i; j++) {
                System.out.print(a + "  ");
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println("");
        }


    }
}