package StriverSheet.Day12_Heaps;

// Implement Max heap: 
// Two main operations are performed in this stock
// 1. Construct a Max Leap with insert method
// 2. Remove the max element(root) and heapify(shuffle the nodes in order to reconstruct) the MaxHeap.

//Details: https://www.geeksforgeeks.org/max-heap-in-java/

// Properties of MaxHeap :
//1. It is Complete Binary tree
//2. Value of parent node is also greater than child nodes

// Complete Binary tree: means each node will have at most 2 nodes. 
// Only leaf nodes can have less than 2 childs , also except the lowest level nodes are filled from as left as possible.

// Max heap is typically represented as an array.

// In MaxHeap:
// If nodes are maintained in an array. You can reach parent node's index with (n-1)/2.
// You can reach left child index with (2n+1) and  right child index with (2n+2)

// NOTE: MaxHeaps.png in this folder

class Heap {
    public int[] heap;
    public int size = 0;

    // during initalizing give a high value here
    public Heap(int maxSize) {
        heap = new int[maxSize];
        size = 0; // This has to be initialized with 0 and will be increased with each new item
                  // addition in heap.
                  // If number of values in max heap reduce, this value also reduces and
                  // vice-versa
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // Insert new node in maxHeap
    public void insert(int val) {
        heap[size] = val;
        int current = size;

        while (heap[(current - 1) / 2] < heap[current]) {

            swap((current - 1) / 2, current);
            current = (current - 1) / 2; // make parent as current
        }
        size++;// this is important

    }

    // Removing Max value(root node of Max heap) and heapify
    public void extractMax() {
        int lastNode = heap[size - 1];
        heap[0] = lastNode;
        size--;
        maxHeapify(0);
    }

    public void maxHeapify(int pos) {

        // If leaf node than return, see MaxHeaps.png in this folder to see why this
        // formula works
        if (pos > size / 2 && pos < size) {
            return;
        }

        int leftChildIndex = (2 * pos) + 1;
        int rightChildIndex = (2 * pos) + 2;

        // get bigger child and swap if current value is more than bigger child's value
        int biggerChildIndex = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
        if (heap[pos] < heap[biggerChildIndex]) {
            swap(pos, biggerChildIndex);
            maxHeapify(biggerChildIndex); // recursive call
        }
        return;

    }

    // To display heap
    public void print() {

        // while printing notice loop has to run 'size/2' times, not 'size' times
        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + heap[i]);

            int leftChildIndex = (2 * i) + 1;
            int rightChildIndex = (2 * i) + 2;

            if (leftChildIndex < size) // if the child is out of the bound
                                       // of the array
                System.out.print(" Left Child Node: "
                        + heap[leftChildIndex]);

            if (rightChildIndex < size) // if the right child index must not
                                        // be out of the index of the array
                System.out.print(" Right Child Node: "
                        + heap[rightChildIndex]);

            System.out.println(); // for new line
        }
    }

}

public class ImplementMaxHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        heap.print();
        ;

        heap.extractMax();
        System.out.println();
        System.out.println("After removing max value(root node)");
        // After removing max value(root node)
        heap.print();
    }
}
