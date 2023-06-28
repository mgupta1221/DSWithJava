package StriverSheet.Day13_Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class test1 {

    public static void main(String[] args) {
        QCustom q = new QCustom(4);

        // print Queue elements
        q.printQueue();

        // inserting elements in the queue
        q.Enqueue(20);
        q.Enqueue(30);
        q.Enqueue(40);
        q.Enqueue(50);

        // print Queue elements
        q.printQueue();

        // insert element in the queue
        q.Enqueue(60);

        // print Queue elements
        q.printQueue();

        q.Dequeue();
        q.Dequeue();
        System.out.println(
                "\nafter two node deletion\n\n");

        // print Queue elements
        q.printQueue();

    }

}

class QCustom {
    int[] arr;
    int size;
    int front = -1;
    int rear = -1;

    QCustom(int size) {
        arr = new int[size];
        this.size = size;
    }

    /*----------------- Public Functions of Queue -----------------*/

    public void printQueue() {
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
        // Implement the isEmpty() function
    }

    void Enqueue(int data) {
        if (rear < size - 1) {
            System.out.println("Queue is full");
            return;
        }

        arr[++rear] = data;
        // Implement the enqueue() function
    }

    int Dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        }
        int item = arr[rear];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return item;
    }

    int front() {

        return arr[front];
        // Implement the front() function
    }
}
