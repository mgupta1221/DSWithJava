package TestQuestions;

import java.util.Scanner;

// https://www.hackerrank.com/contests/test-3-1633882344/challenges/easy-pattern-5

// 1 2 3 4 5 6
// 13 14 15 16 17 18
// 25 26 27 28 29 30
// 31 32 33 34 35 36
// 19 20 21 22 23 24
// 7 8 9 10 11 12
public class Test1Q1 {

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        int n = 6;
        int counter = 1;
        int gap = 0;
        int currentRow = 0;
        int numsPrinted = 0;

        while (numsPrinted < n * n) {
            counter = gap + 1;
            for (int i = 0; i < n; i++) {
                System.out.print(counter + "\t");
                counter++;
                numsPrinted++;
            }
            currentRow++;
            if (n % 2 == 0) {
                if (currentRow == (n / 2) ) {
                    gap += n;
                } else if (currentRow < n / 2) {
                    gap += n * 2;
                } else if (currentRow > n / 2) {
                    gap -= n * 2;
                }
            } else {
                if (currentRow == (n / 2) + 1) {
                    gap = gap - n;
                } else if (currentRow <= n / 2) {
                    gap += n * 2;
                } else if (currentRow > n / 2) {
                    gap -= n * 2;
                }
            }

            System.out.println("");

        }

    }

}
