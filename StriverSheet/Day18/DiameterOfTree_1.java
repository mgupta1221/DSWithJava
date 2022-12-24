package StriverSheet.Day18;

public class DiameterOfTree_1 {

    // Problem: LC 543: https://leetcode.com/problems/diameter-of-binary-tree/
    // The diameter of a binary tree is the length of the longest path between any
    // two nodes in a tree. This path may or may not pass through the root.

    // Solution for both approach 1 and 2:
    // https://www.youtube.com/watch?v=S0Bwgtn32uI&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=45

    // Approach: Remember the aproach from here. Approach 2 is just the optimized
    // version. This implemetation has too many recursive calls
    // This uses height function as well which is also a recursive call. So we have
    // optimized in Approach 2. To avoid those recursive calls for height we return
    // both 'dia' and 'height' via
    // a class object. See DiamterOfTree2.java. Notice there are no recursive calls
    // for height in that implementation.

    // 'ld' and 'hd' below are the options if both left and right side exists on
    // the same side of the root node
    private static int diameterOfBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // maxDistance between 2 nodes on left hand side
        int ld = diameterOfBinaryTree(node.left); // faith that it will give the result

        // maxDistance between 2 nodes on right hand side
        int hd = diameterOfBinaryTree(node.right); // // faith that it will give too

        // Notice we are using Height func here- this means:
        // (maxHeight of leftChild, MaxHeight of right Child) + 2 (for distance
        // from self till left and right child)
        int f = HeightOfTree(node.left) + HeightOfTree(node.right) + 2;

        // taking max of 3 values
        return Math.max(ld, Math.max(hd, f));
    }

    // Height of a Binary tree
    private static int HeightOfTree(TreeNode node) {
        if (node == null) {
            return -1;// remember to return -1 (not 0) here becuase we need edge based height (not
                      // node based)
        }
        int leftTreeHeight = HeightOfTree(node.left);
        int rightTreeHeight = HeightOfTree(node.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        // int height = heightOfTree(root);
        // System.out.println(height);
        int result = diameterOfBinaryTree(root);
        System.out.println(result);
    }
}
