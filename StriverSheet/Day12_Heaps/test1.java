package StriverSheet.Day12_Heaps;

import java.util.ArrayList;

class Heap {
    int size;
    int[] heap;

    public Heap(int s) {
        size = 0;
        heap = new int[s];

    }

    public int getRoot() {
        return heap[0];

    }

    public void insert(int item) {
        heap[size] = item;
        int current = size;

        while (heap[(current - 1) / 2] < heap[current]) {
            swap((current - 1) / 2, current);
           
        }
        size++;
    }

    public void extractMax() {
        heap[0] = heap[size - 1];
        size--;
        maxheapify(0);
       
    }

    public void maxheapify(int idx) {

        if (idx > size / 2) {
            return;
        }

        int leftChild = (2 * idx) + 1;
        int rightChild = (2 * idx) + 2;

        int biggerChild = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;

        if (heap[idx] < heap[biggerChild]) {
            swap(idx, biggerChild);
            maxheapify(biggerChild);
        }

    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}

public class test1 {
    public static void main(String[] args) {
        // Heap heap = new Heap(3);
        // heap.insert(5);
        // heap.insert(3);
        // heap.insert(17);
        // heap.insert(10);
        // heap.insert(84);
        // heap.insert(19);
        // heap.insert(6);
        // heap.insert(22);
        // heap.insert(9);

        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 3;

        Heap heap = new Heap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            heap.insert(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            heap.extractMax();
        }
        System.out.println(heap.getRoot());

    }
}