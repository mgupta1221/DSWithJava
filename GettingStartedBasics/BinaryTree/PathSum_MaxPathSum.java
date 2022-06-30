package GettingStartedBasics.BinaryTree;

import java.util.*;

// Leetcode 124
// Solution description: 
// https://www.youtube.com/watch?v=Osz-Vwer6rw
public class PathSum_MaxPathSum {
    static int globalVar_Sum = 0;

    private static int FindMaxPathSum(Node root, int sum) {
        FindMaxPathSumHelper(root);
        return globalVar_Sum; // returning the global variable as it is maintaining the max sum
    }

    public static int FindMaxPathSumHelper(Node root) {

        if (root == null) {
            return 0;
        }
        int a = root.val;
        int leftSum = FindMaxPathSumHelper(root.left);
        int rightSum = FindMaxPathSumHelper(root.right);

        // we will keep calculating the global currentSum considering all max of 3
        // options:
        // 1. Node itself
        // 2. Node + Either left or right child
        // 3. Node + Left + right
        // and update 'currentSum' with max of 3

        int tempResultA = Math.max(a, Math.max(leftSum, rightSum) + a);
        int tempResultB = Math.max(tempResultA, leftSum + rightSum + a);
        globalVar_Sum = Math.max(globalVar_Sum, tempResultB);

        // For each node execution, Return the root + either taking left or right path
        // (as we
        // can't take both left and right since we need a linear path), to be used by
        // its parent
        return tempResultA;

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        int result = FindMaxPathSum(root, 0);
        System.out.println(result);
    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(1, null, null);
        Node child1 = new Node(2, null, null);
        Node child2 = new Node(3, null, null);
        Node child3 = new Node(15, null, null);
        Node child4 = new Node(7, null, null);

        root.left = child1;
        root.right = child2;

        // child2.left = child3;
        // child2.right = child4;

        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}