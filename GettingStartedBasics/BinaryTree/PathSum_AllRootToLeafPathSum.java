package GettingStartedBasics.BinaryTree;

import java.util.*;

// Question : 
// https://www.geeksforgeeks.org/find-all-root-to-leaf-path-sum-of-a-binary-tree/

public class PathSum_AllRootToLeafPathSum {

    private static void PrintAllRootToLeafSum(Node root) {
        PrintAllPathSumHelper(root, 0);
        // return sum;
    }

    private static void PrintAllPathSumHelper(Node root, int currentSum) {
        // if current node is null, just return
        if (root == null) {
            return;
        }

        // If node is not null, add to the sum
        currentSum += root.val;

        // If leaf node, just print and return
        if (root.left == null && root.right == null) {
            System.out.println(currentSum);
            return;
        }

        PrintAllPathSumHelper(root.left, currentSum);
        PrintAllPathSumHelper(root.right, currentSum);
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        PrintAllRootToLeafSum(root);
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