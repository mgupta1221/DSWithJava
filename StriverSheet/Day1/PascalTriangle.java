package StriverSheet.Day1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // https://leetcode.com/problems/pascals-triangle/

    // Approach:
    // To solve the problem, we need to first create an array of size N or numRows
    // (input value). This array is used to store each of the rows expected in the
    // output, so, for example, array[1] = [1,1]. In this array, the number of
    // columns (say, numCols) is equal to the number of the i-th row + 1 (Since,
    // 0-indexed), i.e., for 0-th row, numCols = 1. So, the number of columns is
    // different for each row.

    // Next, we need to run a loop from i = 0 to numRows – 1 (inclusive) in order to
    // store each row in our array. For each of iteration of this loop, we follow
    // the below steps:

    // Create an array of size (i + 1) (For some languages such as C++, you need to
    // create a 2D array at the start of the program and resize array[i] to (i +
    // 1)).
    // Set the first and last value of array[i] to 1.
    // Run another loop from j = 1 to i – 1 (inclusive) and for each iteration put
    // array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
    // After iterating numRows times, you return the array.

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> rowList = new ArrayList<Integer>();
        List<Integer> preList = new ArrayList<Integer>();

        // first loop to create new row
        // second loop to add elements in that row

        for (int i = 0; i < numRows; i++) {
            rowList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // first and last element of a row will always be 1
                    rowList.add(1);
                } else {
                    rowList.add(preList.get(j - 1) + preList.get(j)); // add previous rows j-1 and j'th value
                }
            }
            preList = rowList;
            resultList.add(rowList);

        }
        return resultList;

    }

    public static void main(String[] args) {
        int numRows = 4;
        List<List<Integer>> resultList = generate(numRows);
        printPascalTillNthRow(resultList);

    }

    public static void printPascalTillNthRow(List<List<Integer>> resultList) {

        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

    }

}
