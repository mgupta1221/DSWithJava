package StriverSheet.Day20_BinarySearchTree;

// Problem: LC 700: https://leetcode.com/problems/search-in-a-binary-search-tree/

public class Search_In_BST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left != null && val <= root.val) {
            return searchBST(root.left, val);
        } else if (root.right != null) {
            return searchBST(root.right, val);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST2();
        TreeNode result = searchBST(root, 2);
        System.out.println(result.val);

    }

}
