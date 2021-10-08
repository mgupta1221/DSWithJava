package GettingStartedBasics.TwoDArrays;

import java.util.Scanner;

// Spiral Diplay

//Question:  https://www.youtube.com/watch?v=UPEZBPh1UcU&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=6
//Solution:  https://www.youtube.com/watch?v=SVFXEqn3Ceo&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=7

// Solution: Print items taking 1 outer box at one time.
// To print each box, it will use 4 loops - 1 loop each to print each side.
// Maintain 4 variables MinR, MaxR, minC and MaxC.
// Whenever 1 side is complete reduce the corresponding row or column by 1to avoid printing same element next time

public class SpiralDisplay {
    public static void main(String[] args) {

        // Taking Input from user
        // Scanner scn = new Scanner(System.in);
        // int m = scn.nextInt();
        // int n = scn.nextInt();

        // int[][] arr = new int[m][n];
        // // Taking Input for array
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = scn.nextInt();
        // }
        // }


        
        // Taking automated hardcoded Input
        int m = 3;
        int n = 5;
        var str = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36";
        String[] elementsInArrayFormat = str.split(" ");
        int[][] arr = new int[m][n];
        int conter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
                conter++;
            }
        }

        int minR = 0; // minimumRow
        int minC = 0; // minimumColumn
        int maxR = m - 1; // maximumRow
        int maxC = n - 1;// maximumColumn

        int totalElements = m * n;
        int counter = 0;
        //Check condition in While - running the loop till all number are printed
        while (counter < totalElements) {
            // Printing in box format

            //Loop 1 : Printing Left Column
            for (int i = minR, j = minC; i <= maxR  && counter < totalElements; i++) {//Notice the counter condition as well
                System.out.print(arr[i][j]+ "\t");
                counter++; //increasing th counter right after printing the element
            }
            //increasing mimunColumn (leftmost) after printing left colum to avoid printing of corner element again
            minC++;


            // Loop 2 : Printing Bottom Row
            for (int i = maxR, j = minC; j <= maxC  && counter < totalElements; j++) {
                System.out.print(arr[i][j] + "\t");
                counter++;
            }

            //decreasing maximumRow(bottomMost) to avoid printing of corner element again
            maxR--;

            // Loop 3 : Printing Right column
            for (int i = maxR, j = maxC; i >= minR  && counter < totalElements; i--) {
                System.out.print(arr[i][j] + "\t");
                counter++;
            }
            maxC--;

            // Loop 4 : Printing top row
            for (int i = minR, j = maxC; j >= minC  && counter < totalElements; j--) {
                System.out.print(arr[i][j] + "\t");
                counter++;
            }
            minR++;

           
        }
    }
}
