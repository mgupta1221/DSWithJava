package StriverSheet.Day18;

// LC 110: https://leetcode.com/problems/balanced-binary-tree/

// A height-balanced binary tree is a binary tree in which the depth of the two
// subtrees of every node never differs by more than one.

class BalancedPair {
    int height;
    boolean isBalanced;
}

public class IsBalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        BalancedPair resultPair = IsBalanced_helper(root);
        return resultPair.isBalanced;

    }

    public static BalancedPair IsBalanced_helper(TreeNode root) {
        if (root == null) {
            BalancedPair basePair = new BalancedPair();
            basePair.height = -1;
            basePair.isBalanced = true;
            return basePair;
        }
        BalancedPair leftPair = IsBalanced_helper(root.left);
        BalancedPair rightPair = IsBalanced_helper(root.right);

        BalancedPair myPair = new BalancedPair();
        myPair.height = 1 + Math.max(leftPair.height, rightPair.height);
        myPair.isBalanced = Math.abs(leftPair.height - rightPair.height) <= 1
                && leftPair.isBalanced
                && rightPair.isBalanced;

        return myPair;

    }

    public static int heightOftree(TreeNode root) {

        if (root == null) {
            return -1;
        }
        return 1 + Math.max(heightOftree(root.left), heightOftree(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        boolean result = isBalanced(root);
        System.out.println(result);
    }

}
