package patterns;

import java.util.Scanner;

public class Rough {
    public static void main(String[] args) {
        int n =11;
        int sp = n / 2;
        int st = 1;
        for (int i = 1; i <= n; i++) {
          
            for (int j = 1; j <= sp; j++) {
                if (i == n / 2 + 1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 1; j <= st; j++) {
                System.out.print("X");
            }
            if (i == n / 2 + 1) {
                System.out.print("X");
            }
            if (i <= n / 2) {
                st++;
            } else {
                st--;
            }

            System.out.println("");
        }
    }
}
