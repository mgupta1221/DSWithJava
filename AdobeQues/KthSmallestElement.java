package AdobeQues;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    // Problem: https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
    

    // If the element with the smallest value has the highest priority,
    // then that priority queue is called the min priority queue

    // Approach:
    // For each element, after the Kth element (arr[K] to arr[n-1]),
    // compare it with the root of priority queue:

    // a) If the element is less than the root then remove the root and insert this
    // element into the priority queue
    // b) Else ignore it.

    // Finally, the root of the priority queue is the Kth smallest element.

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        // Max Priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();

    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int result = kthSmallest(arr, 0, arr.length - 1, 3);
        System.out.print(result + " ");

    }
}
