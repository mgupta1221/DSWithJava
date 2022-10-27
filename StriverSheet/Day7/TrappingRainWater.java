package StriverSheet.Day7;

public class TrappingRainWater {

    // LC 42 - https://leetcode.com/problems/trapping-rain-water/

    // Solution Approach 1: TC: O(N) , SC: O(N)
    // Approach name: Array preprocessing
    // Solution explanation: https://www.youtube.com/watch?v=UZG3-vZlFM4

    // Solution Approach 2: TC: O(N) , SC: O(1)
    // Approach name: 2 Pointers
    // Solution explanation: https://www.youtube.com/watch?v=C8UjlJZsHBw
    // (See from: 26:01 sec)
    public static int trap(int[] height) {
        int trappedWater = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return trappedWater;

    }

    // Solution(Optimized)
    public static int trap_optimized(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];

        int trappedWater = 0;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;
            }
        }
        return trappedWater;

    }

    public static void main(String[] args) {
        int[] heights = { 3, 1, 2, 4, 0, 1, 3, 2 };
        // int result = trap(heights);

        int result = trap_optimized(heights);
        System.out.println((result));

    }

}
