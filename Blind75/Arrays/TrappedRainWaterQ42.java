package Blind75.Arrays;

public class TrappedRainWaterQ42 {
    public int trap(int[] height) {
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxHeightLeft[i] = height[i];
            } else {
                maxHeightLeft[i] = Math.max(maxHeightLeft[i - 1], height[i]);
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxHeightRight[i] = height[i];
            } else {
                maxHeightRight[i] = Math.max(maxHeightRight[i + 1], height[i]);
            }
        }

        for (int i = 0; i < height.length; i++) {
            System.out.print(maxHeightLeft[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < height.length; i++) {
            System.out.print(maxHeightRight[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < height.length; i++) {
            System.out.print(Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i] + " ");
        }
        int trappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i];
        }
        return trappedWater;

    }

    public static void main(String[] args) {
        TrappedRainWaterQ42 trw = new TrappedRainWaterQ42();
        // int[] heights = { 4, 2, 0, 3, 2, 5 };
        int[] heights = { 4, 3, 5, 3, 2, 4 };
        System.out.println(trw.trap(heights));
    }
}
