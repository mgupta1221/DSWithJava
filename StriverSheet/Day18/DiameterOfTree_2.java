package StriverSheet.Day18;

// Problem: https://leetcode.com/problems/diameter-of-binary-tree/
// The diameter of a binary tree is the length of the longest path between any
// two nodes in a tree. This path may or may not pass through the root.

// Solution for both approach 1 and 2:
// https://www.youtube.com/watch?v=S0Bwgtn32uI&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=45

// Approach 2
// This approach avoids recursive calls for calculating height
class DiaPair {
    int dia;
    int height;
}

public class DiameterOfTree_2 {

    public static class DiaPair {
        int height;
        int dia;
    }

    private static DiaPair diameterOfBinaryTree(TreeNode node) {
        if (node == null) {
            DiaPair pair = new DiaPair();
            pair.height = -1;
            pair.dia = 0;
            return pair;
        }

        DiaPair leftPair = diameterOfBinaryTree(node.left);

        DiaPair rightPair = diameterOfBinaryTree(node.right);

        DiaPair mp = new DiaPair();

        mp.height = Math.max(leftPair.height, rightPair.height) + 1;

        int x1 = leftPair.height + rightPair.height + 2; // height from either side
        int x2 = leftPair.dia;
        int x3 = rightPair.dia;

        mp.dia = Math.max(x1, Math.max(x2, x3));
        return mp;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();

        DiaPair result = diameterOfBinaryTree(root);
        System.out.println(result.dia);
    }
}
