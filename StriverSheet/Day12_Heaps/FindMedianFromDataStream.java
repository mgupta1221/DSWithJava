package StriverSheet.Day12_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

// Problem: https://leetcode.com/problems/find-median-from-data-stream/

// Solution video: https://www.youtube.com/watch?v=Yv2jzDzYlp8

// Idea is to create 1 MaxHeap and 1 MinHeap
// We distribute the elements in both  with few rules
//  Base Rule is MinHeap will never have more elements than MaxHeap and also, Maxheap will have elements lesser than Median and Minheap will have elements more than Median
// Maxheap <-> median  <-> MinHeap

// Insertion logic in MinHeap or Maxheap
// 1. Put element in maxheap if: MaxHeap is empty, or, if new element's value is less than max value in MaxHeap
// If both condition are false put element in MinHeap
// 2. Once element is placed by above rule inside MaxHeap ,or, MinHeap, see if :
//    If elements in MinHeap are more than elements in Maxheap - if Yes, move 1 element from Minheap to Maxheap
//    If Maxheap have 2 or more elements than Min heap -> If Yes, move element from max to Min heap

// For Median -

//If Min and Maxheap have equal number of elements than averge of peak elements from both will be the answer
//Else If Size are not equal than Peak of MaxHeap will be answer

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();

    }

    public void addNum(int num) {
        // If maxHeap is empty or number is less than maximum value in MaxHeap
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Hamesha maxheap mai values jyada honi chahiye..to agar min heap mai jyada
        // values hain
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
