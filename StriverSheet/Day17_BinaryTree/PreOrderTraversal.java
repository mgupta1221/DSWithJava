package StriverSheet.Day17_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import StriverSheet.Day17_BinaryTree.TreeNode;

// Problem : LC 144: https://leetcode.com/problems/binary-tree-preorder-traversal/

// Time Complexity: O(N).
//Reason: We are traversing N nodes and every node is visited exactly once.

public class PreOrderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preOrderTraversal_Helper(root, list);
        return list;
    }

    public static void preOrderTraversal_Helper(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);// adding root node first for PreOrder

            if (root.left != null)
                preOrderTraversal_Helper(root.left, list);

            if (root.right != null)
                preOrderTraversal_Helper(root.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        List<Integer> list = preorderTraversal(root);

        System.out.println(list);
    }

}
