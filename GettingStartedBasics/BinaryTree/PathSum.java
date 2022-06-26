package GettingStartedBasics.BinaryTree;

// Leetcode 112
// Solution:  https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/

// or https://www.youtube.com/watch?v=3LKHFfuqlIg&list=PL-Jc9J83PIiHgjQ9wfJ8w-rXU368xNX4L&index=56
public class PathSum {

    private static boolean PathSum(Node root, int targetSum) {
        // boolean ans = false;

        if (root == null) {
            return false;
        }

        if (targetSum == root.val) {
            return true;
        } 

        return PathSum(root.left, targetSum - root.val) || PathSum(root.right, targetSum - root.val);

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        boolean result = PathSum(root, 31);
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