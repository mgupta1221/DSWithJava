package StriverSheet.Day18;

import java.util.ArrayList;

// Problem LC 236: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p 
// and q as descendants (where we allow a node to be a descendant of itself).”
// Basically node where path collide while going towards root from both nodes

// Appraoch 1: Find Node to Root path for both nodes and return the first common node which is the LCA 

// Approach 2: Simpler approach but with logic: We will find 'p' and 'q' in the tree with recursion.
// Case 1: If both nodes could NOT be found on LEFT subtree than we will return the root of RIGHT subTree as LCA
// Case 2: If both nodes could NOT be found on RIGHT subtree than we will return the root of LEFT subTree as LCA
// Case 3: If both nodes could NOT be found on LEFT and Right Subtree, we will return the root as LCA
// Full explanation here- https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/

public class LCA_Of_BinaryTree {

    // Approach 1:
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> list1 = NodeToRootPath(root, p.val);
        ArrayList<TreeNode> list2 = NodeToRootPath(root, q.val);

        TreeNode resultNode = new TreeNode(-1);
        for (TreeNode treeNode : list2) {
            if (list1.contains(treeNode)) {
                resultNode = treeNode;
                break;
            }
        }
        return resultNode;
    }

    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root, int nodeVal) {
        ArrayList<TreeNode> list = new ArrayList<>();
        NodeToRootPath_helper(root, nodeVal, list);
        return list;
    }

    public static boolean NodeToRootPath_helper(TreeNode root, int nodeVal, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root.val == nodeVal) {
            list.add(root);
            return true;
        }
        boolean result = NodeToRootPath_helper(root.left, nodeVal, list);
        if (result) {
            list.add(root);
            return result;
        }
        result = NodeToRootPath_helper(root.right, nodeVal, list);
        if (result) {
            list.add(root);
            return result;
        }
        return false;

    }

    // Approach 2 - Simpler code with logic
    public static TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor_2(root.left, p, q);
        TreeNode right = lowestCommonAncestor_2(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50, null, null);
        TreeNode child1 = new TreeNode(25, null, null);
        TreeNode child2 = new TreeNode(75, null, null);
        TreeNode child3 = new TreeNode(12, null, null);
        TreeNode child4 = new TreeNode(37, null, null);
        TreeNode child5 = new TreeNode(30, null, null);
        TreeNode child7 = new TreeNode(45, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        // TreeNode result = lowestCommonAncestor(root, child5, child3); // Finding for
        // 25 and 75, Ans:

        TreeNode result = lowestCommonAncestor_2(root, child5, child3); // Finding for 25 and 75, Ans: 50
        System.out.println(result.val);
    }

}
