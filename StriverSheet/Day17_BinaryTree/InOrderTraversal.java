package StriverSheet.Day17_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import StriverSheet.Day17_BinaryTree.TreeNode;

// Problem : LC 94: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

// Time Complexity: O(N).
//Reason: We are traversing N nodes and every node is visited exactly once.

public class InOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorderTraversal_Helper(root, list);
        return list;
    }

    public static void inorderTraversal_Helper(TreeNode root, List<Integer> list) {
        if (root != null) {

            if (root.left != null)
                inorderTraversal_Helper(root.left, list);

            list.add(root.val); // adding root node in the middle for InOrder

            if (root.right != null)
                inorderTraversal_Helper(root.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        List<Integer> list = inorderTraversal(root);

        System.out.println(list);
    }

}
