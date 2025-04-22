package Blind75;

import java.util.Arrays;

// Aproach:

// 1. Sort the intervals based on their end time (ascending).
// 2. Iterate through the intervals, and compare the current interval's start with the previous interval’s end.
// 3. If overlapping, increment the removal counter.
// 4. If not overlapping, update the end time.

// We are using greedy strategy, when two intervals overlap, you should keep the one
// that ends earlier i.e., // don’t update prev unless the current interval doesn’t
// overlap. (ELSE case below)

// e.g.  [1,11]   [2,12]   [11,22] [1,100]

// Initialize:
// prevEnd = 11 (end of first interval)
// count = 0

// Now Loop through from index 1:

// interval = [2,12], 2 < 11 ⇒ Overlap → count = 1
// interval = [11,22], 11 >= 11 ⇒ No overlap → prevEnd = 22 // Notice only updating when there is no overlap
// interval = [1,100], 1 < 22 ⇒ Overlap → count = 2

public class NonOverlappingIntervals435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Pair[] pairs = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Pair p = new Pair(intervals[i][0], intervals[i][1]);
            pairs[i] = p;
        }
        Arrays.sort(pairs);
        Pair prev = pairs[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prev.end > pairs[i].start) {
                count++;
            } else {
                prev = pairs[i];// Update only when non-overlapping
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

}

class Pair implements Comparable<Pair> {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Pair p) {
        return this.end - p.end;
    }
}
