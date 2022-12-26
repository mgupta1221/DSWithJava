package StriverSheet.Day20_BinarySearchTree;

// Problem: LC 1008: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class Construct_BST_From_Preorder {

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        return bstFromPreorder_Helper(preorder, 0, preorder.length);

    }

    public static TreeNode bstFromPreorder_Helper(int[] preorder, int start, int end) {

        if (start >= end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);

        int newEnd = start + 1;
        while (newEnd < preorder.length && preorder[start] > preorder[newEnd]) {
            newEnd++;
        }
        root.left = bstFromPreorder_Helper(preorder, start + 1, newEnd);
        root.right = bstFromPreorder_Helper(preorder, newEnd, end);
        return root;

    }

    public static void main(String[] args) {
        int[] nums = { 8, 5, 1, 7, 10, 12 };
        TreeNode result = bstFromPreorder(nums);
        TreeNode.PrintTree(result);

    }

}
