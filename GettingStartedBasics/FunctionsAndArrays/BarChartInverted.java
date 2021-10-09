package GettingStartedBasics.FunctionsAndArrays;

import java.util.Scanner;

// Check readme in folder
// https://www.youtube.com/watch?v=lOsmPMihcTM&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=80

public class BarChartInverted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();
        int[] arr = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        // Getting the max Value
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 1; i <= max; i++) {
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
