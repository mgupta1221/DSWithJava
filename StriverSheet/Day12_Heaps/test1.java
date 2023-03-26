package StriverSheet.Day12_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class test1 {

    public static void main(String[] args) {
        int A[] = { 1, 4, 2, 6 };
        int B[] = { 2, 5, 1, 6 };
        int N = A.length;
        int K = 3;

        KMaxCombinations_Optimized(A, B, N, K);

    }
}