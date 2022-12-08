package StriverSheet.Day13_Stacks;

import java.util.ArrayDeque;
import java.util.Queue;

// In this case, trick is only in the push method

class stack {
    Queue<Integer> q = new ArrayDeque<>();

    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove()); // or use poll(), both are same
        }
    }

    int pop() {
        return q.remove();
    }

    int top() {
        return q.peek();
    }

    int size() {
        return q.size();
    }
}

public class ImplementStackUsing1Queue {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack: " + s.size());
    }
}
