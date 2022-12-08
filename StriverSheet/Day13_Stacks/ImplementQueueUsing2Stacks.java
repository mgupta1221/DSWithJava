package StriverSheet.Day13_Stacks;

import java.util.Stack;

// Prblem: https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        while (st1.size() != 0) {
            st2.push(st1.pop());
        }
        st1.push(x);

        while (st2.size() != 0) {
            st1.push(st2.pop());
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.size() == 0;
    }
}

public class ImplementQueueUsing2Stacks {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        // System.out.println("The size of the queue is " + q.size());
    }

}
