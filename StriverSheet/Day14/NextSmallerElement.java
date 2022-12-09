package StriverSheet.Day14;

import java.util.Stack;

// Problem: https://www.interviewbit.com/problems/nearest-smaller-element/

// Similar to Next Greater Element quesiton solve previously
public class NextSmallerElement {

    public static int[] prevSmaller(int[] A) {

        int[] result = new int[A.length];
        Stack<Integer> st = new Stack<>();
        st.push(A[0]);
        result[0] = -1;

        for (int i = 1; i < result.length; i++) {
            while (!st.isEmpty() && A[i] <= st.peek()) {
                st.pop();
            }
            if (!st.isEmpty()) {
                result[i] = st.peek();
            } else {
                result[i] = -1;
            }
            st.push(A[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };
        int[] result = prevSmaller(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
