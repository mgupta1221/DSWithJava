package StriverSheet.Day1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import GettingStartedBasics.Stack.MergeIntervals.Pair;

public class Test {

    public static void Merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<Pair> st = new Stack<Pair>();
        Pair p1 = new Pair(intervals[0][0], intervals[0][1]);
        st.push(p1);
        for (int i = 1; i < intervals.length; i++) {
            Pair topPair = st.peek();
            Pair currentPair = new Pair(intervals[i][0], intervals[i][1]);

            if (currentPair.start < topPair.end) {
                Pair newPair = new Pair(topPair.start, currentPair.end);
                st.pop();
                st.push(newPair);
            } else {
                st.push(currentPair);
            }
        }
        for (int i = 0; i <= st.size(); i++) {
            Pair p = st.peek();
            System.out.println(p.start + "  " + p.end);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // int nums[] = { 7,6,4,3,1 };
        // int nums[] = { 1, 2 };
        int[][] matrix = { { 1, 3 }, { 15, 18 }, { 8, 10 }, { 2, 6 } };
        // printMatrix(matrix);
        Merge(matrix);
        // printMatrix(matrix);
        // for (int i = 0; i < nums.length; i++) {
        // System.out.print(nums[i] + " ");
        // }

    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] col = new int[m];
        int[] row = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

    }

}
