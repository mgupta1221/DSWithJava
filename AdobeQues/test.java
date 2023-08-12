package AdobeQues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import StriverSheet.Day17_BinaryTree.TreeNode;
import StriverSheet.Day6.Node;

public class test {

    public static int[] calculateSpan(int price[], int n) {
        int[] result = new int[price.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {

            while (!st.isEmpty() && price[i] >= price[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = 1;
            } else {
                result[i] = i - st.peek();
            }
            st.push(i);

        }
        return result;

    }

    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        int[] result = calculateSpan(price, price.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static TreeNode PopulateBinaryTree() {
        TreeNode root = new TreeNode(100, null, null);
        TreeNode child1 = new TreeNode(30, null, null);
        TreeNode child2 = new TreeNode(40, null, null);
        TreeNode child3 = new TreeNode(10, null, null);
        TreeNode child4 = new TreeNode(20, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        return root;
    }
}
