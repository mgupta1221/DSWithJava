package StriverSheet.Day18;

public class DiameterOfTree {

    // Problem: https://leetcode.com/problems/diameter-of-binary-tree/
    // The diameter of a binary tree is the length of the longest path between any
    // two nodes in a tree. This path may or may not pass through the root.

    public static int diameterOfBinaryTree(TreeNode node) {
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        int result = diameterOfBinaryTree(root);
        System.out.println(result);
    }
}
