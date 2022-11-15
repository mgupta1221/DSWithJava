package GettingStartedBasics.Stack;

import java.util.Arrays;
import java.util.Stack;

//Leetcode 56

// https://leetcode.com/problems/merge-intervals/

// Solution video:
// https://www.youtube.com/watch?v=XsOI7fpx8IY&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=23

// Approach :
// Sort the arrays of array by start time
// To sort we store the array set {a,b} in a class and sort it using compareTo() if Comparable interface
// Than we create an array, and push the first class object and compare the next element's start with its end
// If start and end overlap we merge the pair and push it back to the stack and do it till the last class object

public class MergeIntervals {
    public static class Pair implements Comparable<Pair> {
        public int start;
        public int end;

        public Pair(int st, int end) {
            this.start = st;
            this.end = end;
        }

        // Notice how sorting is applied using compareTo
        public int compareTo(Pair other) {
            return this.start - other.start;
        }
    }

    public static int[][] merge(int[][] intervals) {
        
        // Storing arrays of array in array of class 'Pair'

        Pair[] pairs = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        // After storing, sorting
        Arrays.sort(pairs);

        // Notice Stack of Class
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < pairs.length; i++) {
            // If first element, just push it to stack
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                if (pairs[i].start > top.end) {
                    st.push(pairs[i]); // if they are NOT overlapping than simply push
                } else {
                    top.end = Math.max(pairs[i].end, top.end); // end will be the higher value of end among both
                }
            }
        }

        // Since lowest is present at the bottom, create a new stack to reverse the
        // order of items
        Stack<Pair> result = new Stack<>();
        while (st.size() > 0) {
            result.push(st.pop());
        }


        int[][] finalResult = new int[result.size()][intervals[0].length];

        for (int j = 0; j < finalResult.length; j++) {
            Pair p = result.pop();
            finalResult[j][0] = p.start;
            finalResult[j][1] = p.end;
        }
        return finalResult;
    }

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] intervals = { { 1, 4 }, { 4, 5 } };
        int[][] result = merge(intervals);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
