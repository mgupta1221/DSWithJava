package AdobeQues;

import java.util.Stack;

//Problem: LC 496  https://leetcode.com/problems/next-greater-element-i/
// Solved earlier

// Soluton :
//https://www.youtube.com/watch?v=rSf9vPtKcmI&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=7

// Approach:  Assign the last element's answer as -1 and push it to the stack

// Important: First things is we have travse from right to left. Also, notice since array is 'long' intgers, we used 'Long' for stack

// Now, we will traverse the bigger array and we will loop in reverse order from n-1 to 0
// For each element in array, we will remove elements from stack till we find elements smaller 
// than the current element. 
// IF we find a greater element than that value is the answer for the current element
// ELSE If Stack gets empty, answer for that element is -1. 

// Important : At the END, keep pushing the current element to the stack on each iteration.
// Algorithm is:
// 1. Pehle pop karaega
// 2. Fir answer banaega
// 3. fir push karega

// The main intuition behind popping them is that these elements can never be the NGE 
// for any element present at the left of A[i] because A[i] is greater than these elements.

public class NextGreaterElement_I {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<Long>(); // notice how we have declared Long
        st.push(arr[n - 1]);
        long[] result = new long[n];
        result[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = (long) -1;
            } else {
                result[i] = st.peek(); // notice here we are using peek() , NOT pop()
            }
            st.push(arr[i]);

        }
        return result;

    }

    public static void main(String[] args) {
        long[] nums1 = { 1, 3, 4, 2 };
        long[] result = nextLargerElement(nums1, nums1.length);

        for (long n : result)
            System.out.print(n + " ");

    }
}
