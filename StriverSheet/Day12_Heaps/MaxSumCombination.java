package StriverSheet.Day12_Heaps;

import java.util.*;

public class MaxSumCombination {
    // Problem: https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/

    // BruteForce approach: Create a Max heap (using Priority Queue, notice how we
    // have created MaxHeap by using Collections.reverseOrder() and than remove()
    // element to get max sum values
    // Time Complexity: O(N2)
    // Auxiliary Space : O(N2)

    // Optimized approach:
    // Instead of brute-forcing through all the possible sum combinations, we should
    // find a way to limit our search space to possible candidate sum combinations.
    // Sort the 2 arrays
    // Create a max heap i.e priority_queue to store the sum combinations
    // along with the indices of elements from both arrays A and B which make up the
    // sum.
    // IMPORTANT: Heap is ordered by the sum. See "Comparable" Interface
    // implementation on Priortiy Queue.
    // Also notice definition of Priority Queue : Collections.reverseOrder()

    // Time Complexity : O(N log N) assuming K <= N
    // Auxiliary Space : O(N)

    // Approach 1:
    public static void KMaxCombinations_BruteForce(int A[], int B[],
            int N, int K) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                pq.add(A[i] + B[j]);
            }
        }

        for (int i = 0; i < K; i++) {
            int item = pq.remove();
            System.out.println(item);
        }
    }

    // Approach 2 (Optimized) :
    public static void KMaxCombinations_Optimized(int A[], int B[],
            int N, int K) {

        Arrays.sort(A);
        Arrays.sort(B);

        int l = A.length - 1;
        int m = B.length - 1;

        // Max Heap
        PriorityQueue<PairSum> pq = new PriorityQueue<PairSum>(Collections.reverseOrder());

        HashSet<Pair2> pairs = new HashSet<Pair2>();
        pq.add(new PairSum(A[l] + B[m], l, m));
        pairs.add(new Pair2(A[l], B[m]));

        for (int i = 0; i < K; i++) {
            PairSum max = pq.poll();
            System.out.println(max.sum);

            l = max.l - 1;
            m = max.m;

            if (l >= 0 && m >= 0 && !pairs.contains(new Pair2(l, m))) {
                pq.add(new PairSum(A[l] + B[m], l, m));
                pairs.add(new Pair2(l, m));
            }
            l = max.l;
            m = max.m - 1;

            if (l >= 0 && m >= 0 && !pairs.contains(new Pair2(l, m))) {
                pq.add(new PairSum(A[l] + B[m], l, m));
                pairs.add(new Pair2(l, m));
            }
        }

    }

    public static void main(String[] args) {

        int A[] = { 1, 4, 2, 6 };
        int B[] = { 2, 5, 1, 6 };
        int N = A.length;
        int K = 3;

        // Function Call
        // KMaxCombinations_BruteForce(A, B, N, K);

        KMaxCombinations_Optimized(A, B, N, K);
    }

}

class PairSum implements Comparable<PairSum> {
    public int sum;
    public int l;
    public int m;

    public PairSum(int sum, int l, int m) {
        this.sum = sum;
        this.l = l;
        this.m = m;
    }

    public int compareTo(PairSum pair) {
        return this.sum - pair.sum;

    }
}

class Pair2 {
    public int l;
    public int m;

    public Pair2(int l, int m) {
        this.l = l;
        this.m = m;
    }
}
