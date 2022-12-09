package StriverSheet.Day13_Stacks;

import java.util.HashMap;
import java.util.Stack;

//Problem: LC 496  https://leetcode.com/problems/next-greater-element-i/

// Soluton :
//https://www.youtube.com/watch?v=rSf9vPtKcmI&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=7

// Approach:  Assign the last element's answer as -1 and push it to the stack

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

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // This Hashmap will store for each element <Element, NextGreaterValue>

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        map.put(nums2[nums2.length - 1], -1);
        st.push(nums2[nums2.length - 1]);

        for (int i = nums2.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                map.put(nums2[i], -1); // if stack gets empty, no greater element found
            } else {
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] result = nextGreaterElement(nums1, nums2);

        for (int n : result)
            System.out.print(n + " ");

    }
}
