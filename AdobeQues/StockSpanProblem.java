package AdobeQues;

import java.util.Stack;

// LC: 901 Problem: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

// 2 approaches:
// Approach 1(Optimized): Solved with the technique of "Next Greater Element"
// Approach 2: Without using stack (using List)

// In approach 2: In worst case, for 1st input it will check 1 time in the list,
// for 2nd input it will check 2 times, so on..
// For nth input(last input) it will iterate n times.
// Time Complexity = 1+2+3+....n = n*(n+1)/2 = O(n2)

public class StockSpanProblem {
    Stack<Integer> st = new Stack<>();
    int[] prices = new int[1000];
    int itr;

    public StockSpanProblem() {
        itr = 0;
        st.push(itr); // pushing first value
    }

    public int next(int price) {
        int result = 0;
        prices[itr] = price;

        while (!st.isEmpty() && price >= prices[st.peek()]) {
            st.pop();
        }

        if (st.isEmpty()) {
            result = itr + 1; /// this is iportant
        } else {
            result = itr - st.peek();
        }
        st.push(itr);// notice itr is pushed first before incrementing becuase we have to consider
                     // this current 'itr' in next iteration
        itr++;

        return result;
    }

    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        StockSpanProblem obj = new StockSpanProblem();

        for (int i = 0; i < price.length; i++) {
            int result = obj.next(price[i]);

            System.out.print(result + " ");

        }

    }

}
