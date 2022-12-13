package StriverSheet.Day14;

import java.util.Stack;

// Leetcode 84 : https://leetcode.com/problems/largest-rectangle-in-histogram/

//Solution video:
//https://www.youtube.com/watch?v=0do2734xhnU&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=12

// Solution approach:
// Video for this solution is must 
// Appraoch is same as NextGreaterElement problem

public class LargestAreaHistogram {
    public static int largestRectangleArea(int[] heights) {

        // Part 1 : Finding width for each index TOWARDS RIGHT..jab tak apne se chota
        // element na mil jaye tab tak ka distance is the width on the
        // right side

        // For next Greater height value on the right, we will loop from right to left,
        // and vice versa
        int[] rb = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        // We will store index because differnce of index will be the width of Histogram
        // For last element, its own index will be the heighest length possible.
        st.push(heights.length - 1);
        // If element is not found to the right, than we will have lastIndex+1 as its
        // height, and If element is not found to the left, than we will have
        // firstIndex-1 i.e. -1 as its height.
        // This is becuase if next smaller element is not found on either side than
        // total width = n - ( -1 ) -1
        rb[heights.length - 1] = heights.length;

        for (int i = heights.length - 2; i >= 0; i--) {

            // apne se saare badon ko pop kara dega ye while loop
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek(); // chota wala ab stack ke top pe hai..wahi uski bundary hai
            }
            st.push(i);

        }

        // Part 2 : Finding width for each index TOWARDS LEFT now
        int[] lb = new int[heights.length];
        Stack<Integer> st2 = new Stack<>();

        // For first element, its own index(0) will be the heighest length possible.
        st2.push(0);
        // If element is not found to the left, than we will have
        // firstIndex-1 i.e. -1 as its index height.
        lb[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            while (!st2.isEmpty() && heights[i] < heights[st2.peek()]) {
                st2.pop();
            }
            if (st2.isEmpty()) {
                lb[i] = -1;
            } else {
                lb[i] = st2.peek();
            }
            st2.push(i);
        }

        // At the end finding largest area
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < lb.length; i++) {
            int width = rb[i] - lb[i] - 1;// Important to remeber this formula
            int height = heights[i];
            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = { 1, 1 };
        int result = largestRectangleArea(heights);
        System.out.print("Largest area: " + result);

    }
}
