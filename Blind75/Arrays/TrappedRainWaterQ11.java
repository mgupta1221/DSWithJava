package Blind75.Arrays;

// This solution is different from the one in TrappedRainWaterQ42.java

// This is a two-pointer approach to solve the problem.

//  Explanatin below: 
public class TrappedRainWaterQ11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        TrappedRainWaterQ11 trw = new TrappedRainWaterQ11();
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(trw.maxArea(heights));
    }

}

// 1. Loop Until left < right:

// Move the shorter height pointer:
// If height[left] < height[right], increment left.
// Else, decrement right.

// Why Move the Shorter Height?
// The area depends on the smaller height between height[left] and
// height[right].
// If we move the taller height, the new width is smaller, but the height
// remains constrained by the shorter one.
// If we move the shorter height, we have a chance to get a larger height with a
// decent width.
// Complexity Analysis:
// Time Complexity: O(n) since we traverse the array with two pointers.
// Space Complexity: O(1) as we use only a few extra variables
