package Blind75.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class NonOverlappingIntervals435 {

    public static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair other) {
            if (this.end == other.end) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            }
        }

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Pair[] pairs = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Pair p = new Pair(intervals[i][0], intervals[i][1]);
            pairs[i] = p;
        }
        Arrays.sort(pairs);
        int count = 1; // count of non-overlapping intervals
        Pair prev = pairs[0];

        for (int i = 1; i < intervals.length; i++) {
            // finding non-overlapping intervals, Notice "=" here
            if (pairs[i].start >= prev.end) {
                count++;
                prev = pairs[i];
            }
        }

        return intervals.length - count;

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

        int result = NonOverlappingIntervals435.eraseOverlapIntervals(intervals);
        System.out.println(result);

    }
}
