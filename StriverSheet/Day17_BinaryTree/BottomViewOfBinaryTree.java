package StriverSheet.Day17_BinaryTree;

import java.util.*;
// Solution Approach :
// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// This is not on LeetCode

//NOTE: Prerequisite First understand "Vertical order traversal" and "Top View" of a Binary Tree
// For Top view - just add 0th index value of the ArrayList, see below in main function

public class BottomViewOfBinaryTree {
    public static ArrayList<Integer> VerticalOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        TreeMap<Integer, List<Integer>> list = new TreeMap<Integer, List<Integer>>();

        verticalOrderTraversal_helper(root, list, 0);

        Collection<List<Integer>> values = list.values();

        // For Top view only change is add in the line below - result.add(val.get(0));
        for (List<Integer> val : values) {
            result.add(val.get(val.size() - 1));
        }
        return result;

    }

    public static void verticalOrderTraversal_helper(TreeNode root, TreeMap<Integer, List<Integer>> list,
            int hd) {

        if (root == null)
            return;

        if (list.containsKey(hd)) {
            List<Integer> values = list.get(hd);
            values.add(root.val);
            list.put(hd, values);
        } else {
            List<Integer> values = new ArrayList<>();
            values.add(root.val);
            list.put(hd, values);
        }

        if (root.left != null) {
            verticalOrderTraversal_helper(root.left, list, hd - 1);

        }
        if (root.right != null) {
            verticalOrderTraversal_helper(root.right, list, hd + 1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        ArrayList<Integer> result = VerticalOrderTraversal(root);
        for (int node : result) {
            System.out.println(node);
        }

    }
}
