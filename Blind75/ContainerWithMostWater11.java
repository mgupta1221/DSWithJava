package Blind75;

public class ContainerWithMostWater11 {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left <= right) {
            int area = Math.min(height[right], height[left]) * (right - left); // current area
            maxArea = Math.max(maxArea, area); // getting maxArea

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int result = maxArea(height);
        System.out.println(result);

    }
}
