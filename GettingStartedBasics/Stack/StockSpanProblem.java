package GettingStartedBasics.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Leetcode 901 : https://leetcode.com/problems/online-stock-span/

//Solution video:
// https://www.youtube.com/watch?v=0BsPlzqksZQ&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=10

// This solution works on Indexes(not on real numbers like in 'Next Greater Element')

// In this problem we have to find Next Greater element to the left

// Approach same as 'Next Greater Element' just that in that we traversed from end
// of the array, here we traversed from 0 to n-1.

// Algorithm is:
// 1. Pehle pop karaega
// 2. Fir answer banaega
// 3. fir push karega

public class StockSpanProblem {
    public static int[] StockSpan(int[] stockPrices) {

        Stack<Integer> st = new Stack<>();
        int[] resultArray = new int[stockPrices.length];
        st.push(0); // notice we are storing index in Stack
        resultArray[0] = 1; // Storing answer in result array

        for (int i = 1; i < stockPrices.length; i++) {
            // keep popping till we are getting lesser elements in Stack
            while (!st.isEmpty() && stockPrices[i] >= stockPrices[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                resultArray[i] = i + 1; // if not found(stack got empty) than index+1 - kyunki is element ne sabko pop
                                        // kara diya iska matlab difference in indexes from left would be uska index+1. +1 isliye
                                        // kyunki index 0 se shuru hota hai
            } else {
                resultArray[i] = i - st.peek(); // if found, (currentIndex-TopIndexInStack) is the answer
            }
            st.push(i);

        }
        return resultArray;

    }

    public static void main(String[] args) {
        int[] stockPrices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] result = StockSpan(stockPrices);

        for (int n : result)
            System.out.print(n + " ");

    }
}
