package StriverSheet.Day21;

// Problem: LC 1373:

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

// Solution Approach: https://www.geeksforgeeks.org/maximum-sub-tree-sum-in-a-binary-tree-such-that-the-sub-tree-is-also-a-bst/

// Approach: We traverse the tree in bottom-up manner. For every traversed node, we store the information of maximum 
// and minimum of that subtree, a variable isBST to store if it is a BST, and a variable sum to store the sum of Left
// and Right subtree(which is also a BST) rooted under the current node.
// We keep updating maxSum (a class object) on each recursive call which is the final answer

// Helper classes : MaxSum and Info below
class MaxSum {
    int maxSum = Integer.MIN_VALUE;
}

class Info {
    int max;
    int min;
    int treeSum;
    boolean isBST;

    public Info() {
    }

    public Info(int max, int min, int treeSum, boolean isBST) {
        this.max = max;// maximum node value of this tree, this is needed to check if the tree will be
                       // BST, or, not by comparing the LeftTree's max with root

        this.min = min; // minimum node value of this tree
        this.treeSum = treeSum;

        this.isBST = isBST;
    }
}

public class Max_Sum_BST_in_BinaryTree {

    public static int maxSumBST(TreeNode root) {
        MaxSum maxSum = new MaxSum();
        maxSumBST_helper(root, maxSum);
        if (maxSum.maxSum < 0) {
            return 0;
        } else {
            return maxSum.maxSum;
        }

    }

    public static Info maxSumBST_helper(TreeNode root, MaxSum maxSum) {
        // Base case
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        // Leaf node
        if (root.left == null && root.right == null) {
            maxSum.maxSum = Math.max(maxSum.maxSum, root.val); // updating maxSum for answer
            return new Info(root.val, root.val, root.val, true); // creating new result and return
        }

        Info L = maxSumBST_helper(root.left, maxSum); // recursive left call
        Info R = maxSumBST_helper(root.right, maxSum); // recursive right call

        Info myresult = new Info(); // creating my own object

        // When right and left subtree are BST
        if (L.isBST && R.isBST && L.max < root.val && R.min > root.val) {
            myresult.isBST = true;

            myresult.min = Math.min(root.val, Math.min(L.min, R.min));
            myresult.max = Math.max(root.val, Math.max(L.max, R.max));
            myresult.treeSum = root.val + L.treeSum + R.treeSum;

            maxSum.maxSum = Math.max(maxSum.maxSum, L.treeSum + R.treeSum + root.val);

            return myresult;
        }
        // creating result when Left and Right are not BST
        myresult.isBST = false;
        myresult.treeSum = R.treeSum + root.val + L.treeSum;
        return myresult;

    }

    public static void main(String[] args) {
        // TreeNode root = TreeNode.PopulateBST3();
        TreeNode root = PopulateBST();

        int result = maxSumBST(root);
        System.out.println(result);

    }

    public static TreeNode PopulateBST() {
        TreeNode root = new TreeNode(-4, null, null);
        TreeNode child1 = new TreeNode(-2, null, null);
        TreeNode child2 = new TreeNode(-5, null, null);

        root.left = child1;
        root.right = child2;

        return root;
    }

}
