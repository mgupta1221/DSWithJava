package StriverSheet.Day20_BinarySearchTree;

// Problem : LC 235 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Full explanation here- https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/

public class LCA_Of_2Nodes_In_BST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);

        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;

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

        TreeNode result = lowestCommonAncestor(root, child5, child3); // Finding for 30 and 12, Ans: 25
        System.out.println(result.val);
    }

}
