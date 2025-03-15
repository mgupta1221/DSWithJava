package Blind75.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals56 {
    public class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair other) {
            return this.start - other.start;
        }
    }

    public int[][] merge(int[][] intervals) {

        Pair[] pairs = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[0]);
            } else {
                Pair p = pairs[i];
                Pair stackPair = st.peek();

                if (p.start < stackPair.end) {
                    Pair newPair = new Pair(stackPair.start, Math.max(p.end, stackPair.end));
                    st.pop(); // remove the top element
                    st.push(newPair); // push the new pair
                } else {
                    st.push(p);
                }
            }
        }
        int idx = 0;
        int[][] result = new int[st.size()][intervals[1].length];
        while (st.size() > 0) {
            Pair p = st.pop();
            result[idx][0] = p.start;
            result[idx][1] = p.end;
            idx++;
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        MergeOverlappingIntervals56 mergeOverlappingIntervals56 = new MergeOverlappingIntervals56();
        int[][] result = mergeOverlappingIntervals56.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

}
