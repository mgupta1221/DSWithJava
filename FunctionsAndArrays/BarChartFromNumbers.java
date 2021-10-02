package FunctionsAndArrays;

import java.util.Scanner;

// Check readme in folder

// https://www.youtube.com/watch?v=L-0IxqvYQKs&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=98

public class BarChartFromNumbers {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = scn.nextInt();
        }
        // Get largest number to print the max height
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 3
        // 2,1,0
        // 2 0 1
        // 0,0 0,1 0,2 X(2<=2) (2<=0) 2<=1
        // 1,0 1,1 1,2 X(1<=2) 1<=0 1<=1
        // 2,0 0<=2 0<=0

        for (int i = max; i > 0; i--) {

            for (int j = 0; j < numberOfElements; j++) {
                if (i <= arr[j]) {
                    System.out.print("X\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }

    }

}
