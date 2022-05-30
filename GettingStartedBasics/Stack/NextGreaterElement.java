package GettingStartedBasics.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Leetcode 496 : https://leetcode.com/problems/next-greater-element-i/

//Solution video:
//https://www.youtube.com/watch?v=rSf9vPtKcmI&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=7

// Approach:  Assign the last element's answer as -1 and push it to the stack

// Now, we will traverse the bigger array and we will loop in reverse order from n-1 to 0
// For each element in array, we will remove elements from stack till we find elements smaller 
// than the current element. 
// IF we find a greater element than that value is the answer for the current element
// ELSE If Stack gets empty, answer for that element is -1. 

// Important : At the END, keep pushing the current element to the stack on each iteration.

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // This Hashmap will store <Element, NextGreaterValue>
        // This will help in fetching NextGreater Value for Nums1 array quickly in O(1)
        // time
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        st.push(nums2[nums2.length - 1]); // this is important step, push the last element to the stack
        map.put(nums2[nums2.length - 1], -1); // last element answer will be -1

        for (int i = nums2.length - 2; i >= 0; i--) {
            // remove elements from stack till elements on stack are smaller than the current element
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
        int[] tempResultArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // System.out.print(map.get(nums1[i]) + " ");
            tempResultArr[i] = map.get(nums1[i]);
        }
        return tempResultArr;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 1, 3, 10, 6, 7 };
        int[] nums2 = { 2, 5, 1, 3, 10, 6, 7 };
        int[] result = nextGreaterElement(nums1, nums2);

        for (int n : result)
            System.out.print(n + " ");

    }
}
