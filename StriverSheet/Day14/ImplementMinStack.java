package StriverSheet.Day14;

import java.util.Stack;

// Problem: LC 155 https://leetcode.com/problems/min-stack/

// Solution:
// https://www.youtube.com/watch?v=8UegNFCUQks

// We will maintain 2 stacks: One with values, Other with minimum Values will that Index(We can also do
// this with 1 Stack and storing the value as Pair<Value, MinValue> as a class object)
// Min value at Index i in stack will be the minimum value from 0 till i.

//  Values in Stack ----> 2 4 1 4 5
//  MinValues in Stack--> 2 2 1 1 1

class Pair {
    int val;
    int minVal;

    public Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.empty()) {
            Pair p = new Pair(val, val);
            st.push(p);
        } else {
            Pair lastElement = st.peek();
            if (lastElement.minVal > val) {
                Pair p = new Pair(val, val);
                st.push(p);
            } else {
                Pair p = new Pair(val, lastElement.minVal);
                st.push(p);
            }
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().minVal;
    }
}

public class ImplementMinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483647);
        int param_1 = obj.getMin();
        System.out.println(param_1);
        obj.push(1);
        int param_2 = obj.top();
        System.out.println(param_2);
        int param_3 = obj.getMin();
        System.out.println(param_3);
        obj.pop();
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}
