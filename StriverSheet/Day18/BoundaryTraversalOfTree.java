package StriverSheet.Day18;

import java.util.ArrayList;
import java.util.List;

// Problem:  LC 545 https://leetcode.com/problems/boundary-of-binary-tree/#

// Solution: https://leetcode.com/problems/boundary-of-binary-tree/solutions/1048529/java-three-passes-recurision-left-bottom-right/

// Code is self explanatory: First we add left side, than leaves, than right side in reverse order

public class BoundaryTraversalOfTree {

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        result.add(root.val);

        if (root.left == null && root.right == null) {
            return result;
        }

        addLeftBoundary(root.left, result); // Notice we are passing left node as root is already added

        addLeafNodesFromLeftToRight(root, result);

        List<Integer> tempRightResult = new ArrayList<>();
        addRightBoundary(root.right, tempRightResult);

        // we can avoid this reverse addiiton in result by adding the node value post
        // recursion(at the end of func) inside function addRightBoundary()
        for (int i = tempRightResult.size() - 1; i >= 0; i--) {
            result.add(tempRightResult.get(i));
        }

        return result;
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) { // avoiding Leaf node
            result.add(root.val);
        }

        if (root.left != null) {
            addLeftBoundary(root.left, result);
        } else if (root.right != null) {
            addLeftBoundary(root.right, result);
        }
    }

    public static void addLeafNodesFromLeftToRight(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        if (isLeaf(root) == true) {
            result.add(root.val);
        }
        addLeafNodesFromLeftToRight(root.left, result);
        addLeafNodesFromLeftToRight(root.right, result);

    }

    public static void addRightBoundary(TreeNode root, List<Integer> tempRightResult) {
        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            tempRightResult.add(root.val);
        }

        if (root.right != null) {
            addRightBoundary(root.right, tempRightResult);
        } else if (root.left != null) {
            addRightBoundary(root.left, tempRightResult);
        }

    }

    public static void main(String[] args) {
        // TreeNode root = PopulateBinaryTree();
        // TreeNode root = PopulateBinaryTree2();
        // TreeNode root = PopulateBinaryTree3();
        TreeNode root = PopulateBinaryTree4(); // Ans 1,3,4,2
        List<Integer> result = boundaryOfBinaryTree(root);

        for (Integer val : result) {
            System.out.print(val + " ");
        }

    }

    // Helper to create tree
    public static TreeNode PopulateBinaryTree2() {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode child1 = new TreeNode(2, null, null);
        TreeNode child2 = new TreeNode(3, null, null);
        TreeNode child3 = new TreeNode(4, null, null);
        TreeNode child4 = new TreeNode(5, null, null);
        TreeNode child5 = new TreeNode(6, null, null);
        TreeNode child6 = new TreeNode(7, null, null);
        TreeNode child7 = new TreeNode(8, null, null);
        TreeNode child8 = new TreeNode(9, null, null);
        TreeNode child9 = new TreeNode(10, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child6;
        child4.right = child7;

        child2.left = child5;

        child5.left = child8;
        child5.right = child9;

        return root;
    }

    public static TreeNode PopulateBinaryTree3() {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode child1 = new TreeNode(2, null, null);
        TreeNode child2 = new TreeNode(3, null, null);
        TreeNode child3 = new TreeNode(4, null, null);

        root.left = child1;

        child1.left = child2;

        child2.left = child3;

        return root;
    }

    public static TreeNode PopulateBinaryTree4() {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode child1 = new TreeNode(2, null, null);
        TreeNode child2 = new TreeNode(3, null, null);
        TreeNode child3 = new TreeNode(4, null, null);

        root.right = child1;

        child1.left = child2;

        child1.right = child3;

        return root;
    }

}
