package AdobeQues;

import java.util.ArrayList;

import StriverSheet.Day6.Node;

public class test {

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {

    }

    public static void main(String[] args) {

        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        ArrayList<Integer> result = spirallyTraverse(matrix, 0, 0);

        for (Integer integer : result) {
            System.out.println(integer + " ");
        }
    }

}
