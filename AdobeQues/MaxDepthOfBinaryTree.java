package AdobeQues;

import StriverSheet.Day17_BinaryTree.TreeNode;

public class MaxDepthOfBinaryTree {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    // New

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepthHelper(root, 0);
    }

    public static int maxDepthHelper(TreeNode root, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }
        return 1 + Math.max(maxDepthHelper(root.left, maxDepth), maxDepthHelper(root.right, maxDepth));

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        int result = maxDepth(root);
        System.out.print(result);
    }

}
