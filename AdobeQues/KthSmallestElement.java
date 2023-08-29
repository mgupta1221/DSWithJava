package AdobeQues;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    // New
    // Problem:
    // https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/

    // If the element with the smallest value has the highest priority,
    // then that priority queue is called the Min priority queue. Min Priority Queue
    // mai sabse pehle sabse chota element pop hoga

    // Kth Smallest find karne ke liye..Max Priority Queue(with
    // Collections.reverseOrder) use karna hoga..kyunki hume bigger elements ko pop
    // karna hai
    // Similarly, Kth Largest find karne ke liye..Min Priority Queue() use karna hoga

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        // Max Priority queue
        // Collections.reverseOrder() ka matlab hai sabse bada element sabse pehle pop
        // hoga
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
