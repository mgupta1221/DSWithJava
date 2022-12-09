package StriverSheet.Day13_Stacks;

// In Queue: Addition happens at "rear", Removal happens from "front"
class QueueCustom {

    int arr[];
    int size;
    int front = -1;
    int rear = -1;

    public QueueCustom(int size) {
        arr = new int[size];
        this.size = size;

    }

    public void Enqueue(int val) {
        if (rear < this.size - 1) {
            rear++;
            arr[rear] = val;

        } else {
            System.out.println("\nQueue is full");
        }
    }

    public void Dequeue() {
        if (front == rear) {
            System.out.println("\nQueue is empty");
            return;
        } else {
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
        }
    }

    // print queue elements
    void printQueue() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        // traverse front to rear and print elements
        for (i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + "->");
        }
        return;
    }
}

public class ImplementQueueUsingArray {

    public static void main(String[] args) {
        // Create a queue of capacity 4
        QueueCustom q = new QueueCustom(4);

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
