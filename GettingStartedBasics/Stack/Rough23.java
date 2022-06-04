package GettingStartedBasics.Stack;

import java.util.*;

public class Rough23 {
    private static int[] NGE(int[] nums) {
        int len = nums.length;
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums[len - 1]);
        result[len - 1] = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            while (st.size() > 0 && nums[i] >= st.peek()) {
                st.pop();
            }

            if (st.size() > 0) {
                result[i] = st.peek();

            } else {
                result[i] = -1;
            }

            st.push(nums[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 6, 2, 3 };
        int[] result = NGE(nums);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
