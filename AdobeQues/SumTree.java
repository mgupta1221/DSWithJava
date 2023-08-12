package AdobeQues;

import java.util.List;
import java.util.Properties;

import StriverSheet.Day17_BinaryTree.TreeNode;

public class SumTree {

    // https://practice.geeksforgeeks.org/problems/sum-tree/1
    // New
    // Approach: Create a help which will return <isSumTree, SumAtRoot>

    public static boolean isSumTree(TreeNode root) {
        Pair result = isSumTreeHelper(root);
        return result.isSum;
    }

    public static Pair isSumTreeHelper(TreeNode root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new Pair(true, root.val);
        }

        Pair p1 = new Pair(true, 0);
        Pair p2 = new Pair(true, 0);
        if (root.left != null) {
            p1 = isSumTreeHelper(root.left);
            if (p1.isSum == false) {// this has to be remembered, if 'left' is not SumTree than return 0 as sum
                return new Pair(false, 0);
            }
        }

        if (root.right != null) {
            p2 = isSumTreeHelper(root.right);
            if (p2.isSum == false) {
                return new Pair(false, 0);
            }
        }

        return new Pair(p1.sum + p2.sum == root.val, p1.sum + p2.sum + root.val);

    }

    public static void main(String[] args) {
        TreeNode root = PopulateBinaryTree();
        boolean result = isSumTree(root);
        System.out.print(result);
    }

    public static class Pair {
        public boolean isSum;
        public int sum;

        public Pair(boolean isSum, int sum) {
            this.isSum = isSum;
            this.sum = sum;

        }

    }

    public static TreeNode PopulateBinaryTree() {
        TreeNode root = new TreeNode(100, null, null);
        TreeNode child1 = new TreeNode(30, null, null);
        TreeNode child2 = new TreeNode(40, null, null);
        TreeNode child3 = new TreeNode(10, null, null);
        TreeNode child4 = new TreeNode(20, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        return root;
    }

}
