package StriverSheet.Day12_Heaps;

// Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/

// Approach 1 - Max Heap (solved below): We will store the given UnSorted array into a Max heap structure by using insert() method.
// Then remove the first (k-1) root nodes using heapify method, the current root node will be kth largest element:

// Time Complexity:
// 1.  Build a Max Heap tree in O(n * log(n)) 
// 2.  Use Extract Max k times to get k maximum elements from the Max Heap O(k*log(n))

// Time complexity: O(n * log(n) + k * log(n)).  
// Auxiliary Space: O(N)

// Important: Time Complexity of inserting a new item in max heap - In the worst case, we need one swap at each level of the tree.
// So the total number of the swaps would be equal to the height of the heap tree. The height of a balanced
// complete tree with N number of nodes is logN. Each swap takes O(1) time.
// Therefore, in the worst case, the time complexity of inserting a node (or, heapifying) in a heap would be O(logN).

// Time Complexity of Extracting max value(deletion of max value i.e. root node) in Max heap: Each deletion operation
//  takes O(log n) time, so the total time complexity of this approach comes out to be O(k * log n). 

// Approach 2: 

class Heap2 {

    public int[] heap;
    public int size;

    public Heap2(int[] arr) {
        heap = new int[arr.length];
        size = 0;

        for (int i = 0; i < arr.length; i++) {
            insert(heap, arr[i]);
        }

    }

    public void insert(int[] heap, int val) {
        heap[size] = val;
        int current = size;
        // compare element with its parent and swap if parent is smaller
        while (heap[(current - 1) / 2] < heap[current]) {
            int temp = heap[(current - 1) / 2];
            heap[(current - 1) / 2] = heap[current];
            heap[current] = temp;
            current = (current - 1) / 2;
        }
        size++;
    }

    public int getRoot() {
        return heap[0];
    }

    public void removeRoot() {
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
    }

    public void heapify(int idx) {

        if (idx >= size / 2 && idx < size) {
            return;
        }

        int leftIndex = (2 * idx) + 1;
        int rightIndex = (2 * idx) + 2;

        int biggerIndex = heap[leftIndex] > heap[rightIndex] ? leftIndex : rightIndex;

        if (heap[idx] < heap[biggerIndex]) {
            int temp = heap[idx];
            heap[idx] = heap[biggerIndex];
            heap[biggerIndex] = temp;
            heapify(biggerIndex);
        }

        return;

    }

    public void print() {

        // while printing notice loop has to run 'size/2' times, not 'size' times
        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + heap[i]);

            int leftChildIndex = (2 * i) + 1;
            int rightChildIndex = (2 * i) + 2;

            if (leftChildIndex < size)
                System.out.print(" Left Child Node: "
                        + heap[leftChildIndex]);

            if (rightChildIndex < size)
                System.out.print(" Right Child Node: "
                        + heap[rightChildIndex]);

            System.out.println(); // for new line
        }
    }
}

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        Heap2 heap = new Heap2(nums);
        heap.print();

        for (int i = 0; i < k - 1; i++) {
            heap.removeRoot();
        }
        return heap.getRoot();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        int result = findKthLargest(nums, 2);

        System.out.println(result);

    }

}
