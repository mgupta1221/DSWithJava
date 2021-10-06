package TwoDArrays;

import java.util.Scanner;

// Exit Point of  - Square 2d ARRAY
//Question: Sqaure Matrix of 0 and 1. One every occurence of 1, control takes a right turn..You have to find the exit point

//Question - https://www.youtube.com/watch?v=FnywCfCcMRk&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=8
//Solution - https://www.youtube.com/watch?v=FUBlb360kqU

public class ExitPointOfMatrix {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        // Taking Input for array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        var direction = 0; // 0 means moving towards East, 1 means South, 2 means West and 3 means North
        int i = 0, j = 0;
        while (i < n && i >= 0 && j < n && j >= 0) {
            switch (direction) {

                case 0: // East
                    if (arr[i][j] != 1) {
                        j++;
                    } else {
                        i++;
                        direction = 1;
                    }

                    break;
                case 1: // South
                    if (arr[i][j] != 1) {
                        i++;
                    } else {
                        j--;
                        direction = 2;
                    }

                    break;
                case 2: // West
                    if (arr[i][j] != 1) {
                        j--;
                    } else {
                        i--;
                        direction = 3;
                    }

                    break;
                case 3:
                    if (arr[i][j] != 1) {
                        i--;
                    } else {
                        j++;
                        direction = 0;
                    }

                    break;
            }

        }
        System.out.println("Exit Point:  i:" + i + " ,j: " + j);

    }
}
