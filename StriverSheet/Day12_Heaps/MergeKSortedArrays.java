package StriverSheet.Day12_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// Problem: 
// https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0

// Solution video: https://www.youtube.com/watch?v=TfpfLepAs20

// Approach: We will use MinHeap and take first element from each array and store it in 
// MinHeap(so that minimum of all elements will be at root always).
// Now in a loop till priorityQueue is not Empty(MinHeap), we will remove the top element and add it
// to out result, and also, add a new number which is the next number in the same array

// Element for MinHeap will be structured with :
// i)   array value, 
// ii)  its index in the array 
// iii) Index of the array which the element belongs to

// Class will have to implement Comparable<> with compareTo() method to sort on value out of 3 fields

class ArrayItem implements Comparable<ArrayItem> {
    public int val;
    public int idx;
    public int arr_num;

    public ArrayItem(int val, int idx, int arr_num) {
        this.val = val;
        this.idx = idx;
        this.arr_num = arr_num;
    }

    public int compareTo(ArrayItem item) {
        return this.val - item.val;
    }
}

public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {

        PriorityQueue<ArrayItem> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayItem item = new ArrayItem(arr[i][0], 0, i);
            pq.add(item);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (pq.size() != 0) {
            ArrayItem item = pq.poll();

            list.add(item.val);
            int currentIndex = item.idx;
            int arr_num = item.arr_num;
            if (currentIndex + 1 < arr[arr_num].length) {
                ArrayItem newItem = new ArrayItem(arr[arr_num][currentIndex + 1], currentIndex + 1, arr_num);
                pq.add(newItem);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 5, 9 },
                { 2, 4, 6 },
                { 12, 14, 16 } };

        ArrayList<Integer> list = mergeKArrays(arr, arr.length);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
