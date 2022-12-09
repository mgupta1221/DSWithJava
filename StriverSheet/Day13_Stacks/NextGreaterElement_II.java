package StriverSheet.Day13_Stacks;

import java.util.HashMap;
import java.util.Stack;

// Problem: LC 503 https://leetcode.com/problems/next-greater-element-ii/description/

// Apparoach: 
// This is similar to part I in this folder. 
// Difference in this problem is We need to make this algorithm work for a circular array in this part II. 
// The only difference between a circular and non-circular array is that while searching for the 
// next greater element in a non-circular array we don’t consider the elements left to the concerned element.
// This can be easily done by inserting the elements of the array A at the end of A, thus making its 
// size double. But we actually don’t require any extra space. We can just traverse the array twice. 
// We actually run a loop 2*N times, where N is the size of the given array. and access element by (i%n) index.

public class NextGreaterElement_II {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        map.put(nums[nums.length - 1], -1);
        st.push(nums[nums.length - 1]);

        int[] result = new int[nums.length];

        for (int i = (n * 2) - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i % n] = -1;

            } else {
                result[i % n] = st.peek();
            }
            st.push(nums[i % n]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 1, 11, 1, 120, 111, 123, 1, -1, -100 };
        int[] result = nextGreaterElements(nums);

        for (int n : result)
            System.out.print(n + " ");

    }
}
