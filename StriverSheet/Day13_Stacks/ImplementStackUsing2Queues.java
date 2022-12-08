package StriverSheet.Day13_Stacks;

import java.util.ArrayDeque;
import java.util.Queue;

// Prblem: https://leetcode.com/problems/implement-stack-using-queues/

class StackUsingQueue {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int val) {
        q1.add(val);
    }

    public int pop() {
        if (q1.size() == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        while (q1.size() != 1) {
            int item = q1.poll(); // 1 2 3 // 1 will get deleted first in queue
            q2.add(item);
        }
        int deletedItem = q1.poll();

        while (q2.size() != 0) {
            int item = q2.poll();
            q1.add(item);
        }
        // You can also swap the queue names intead of 2nd while loop above, as shown
        // below:

        // swap the two queues names
        // Queue<Integer> q = q1;
        // q1 = q2;
        // q2 = q;
        return deletedItem;
    }

    public int top() {
        while (q1.size() != 1) {
            int item = q1.poll();
            q2.add(item);
        }

        int topElement = q1.poll();
        q2.add(topElement);

        while (q2.size() != 0) {
            int item = q2.poll();
            q1.add(item);
        }

        return topElement;
    }

    public boolean empty() {
        return q1.size() == 0;
    }

    int size() {
        return q1.size();
    }
}

public class ImplementStackUsing2Queues {
    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        // 1 2 3

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop(); // 1 2
        System.out.println(s.top());
        s.pop(); // 1
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }

}
