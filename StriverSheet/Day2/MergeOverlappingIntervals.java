package StriverSheet.Day2;

import java.util.*;

// LC 56: https://leetcode.com/problems/merge-intervals/

// Approach:
// 1. Sort the elements by Start time - For this create class Pair with Comparable's compareTo() function
// and convert the pairs into array of Pair class. 
// Use Arrays.sort() and pass Pair[] array to it. Note that Arrays.sort() works only on arrays. 

// 2. After Sorting, run a loop to create Pair objects and push elements into a Stack. Elements are 
// created such that if array's current element's End time is greater than Stack's top element's Start time than
// update the End time of stack's element, else, push the new Pair element to Stack.

//3. Pop the Stack's elements and create a new array[][] (as original input) to return as answer.

class Pair implements Comparable<Pair> {
    int start;
    int end;

    Pair(int st, int end) {
        this.start = st;
        this.end = end;
    }

    public int compareTo(Pair other) {
        return this.start - other.start;
    }
}

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {
        Pair[] pairs = new Pair[intervals.length];

        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(pairs);
        // Arrays.sort(intervals, (a, b) -> a[1] - b[1]); <- Quicker way to sort array
        // using inbuilt func

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < pairs.length; i++) {
            // push the first object to Stack
            if (i == 0) {
                st.push(pairs[0]);
            } else {
                Pair p = st.peek();
                if (pairs[i].start < p.end) {
                    p.end = Math.max(p.end, pairs[i].end);
                } else {
                    st.push(pairs[i]);
                }
            }
        }

        int[][] result = new int[st.size()][intervals[0].length];

        // Dont use St.size in middle condition in below for loop as size will keep
        // reducing with each pop done inside the for loop
        for (int j = 0; j < result.length; j++) {
            Pair p = st.pop();
            result[j][0] = p.start;
            result[j][1] = p.end;
        }
        return result;
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };

        int result[][] = merge(intervals);

        // printing result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

}
