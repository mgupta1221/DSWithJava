package StriverSheet.Day18;

public class DepthOfTree {

    // Problem: LC 104 https://leetcode.com/problems/maximum-depth-of-binary-tree/
    
    // Solution:
    // https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/

    public static int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        return maxDepth_helper(root, max);

    }

    public static int maxDepth_helper(TreeNode root, int max) {

        if (root == null) {
            return max;
        }
        max = 1 + Math.max(maxDepth_helper(root.left, max), maxDepth_helper(root.right, max));
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        int result = maxDepth(root);
        System.out.println(result);
    }

}
