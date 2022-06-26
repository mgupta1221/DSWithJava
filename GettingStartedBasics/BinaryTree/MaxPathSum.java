package GettingStartedBasics.BinaryTree;

import java.util.*;

// Leetcode 124

public class MaxPathSum {

    private static boolean FindMaxPathSum(Node root, int sum) {

        if (root == null) {
            return false;
        }
        if (root.val == sum) {
            return true;
        }

        return FindMaxPathSum(root.left, sum - root.val) || FindMaxPathSum(root.right, sum - root.val);

        // ArrayList<Integer> pathSum = new ArrayList<>();
        // FindMaxPathSumHelper(root, 0, pathSum);
    }

    // private static void FindMaxPathSumHelper(Node root, int currentSum,
    // ArrayList<Integer> pathSum) {
    // ArrayList<Integer> pathSum = new ArrayList<>();

    // FindMaxPathSumHelper(root, 0, pathSum);

    // }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        Boolean result = FindMaxPathSum(root, 38);
        System.out.println(result);

    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(3, null, null);
        Node child1 = new Node(9, null, null);
        Node child2 = new Node(20, null, null);
        Node child3 = new Node(15, null, null);
        Node child4 = new Node(7, null, null);

        root.left = child1;
        root.right = child2;

        child2.left = child3;
        child2.right = child4;

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