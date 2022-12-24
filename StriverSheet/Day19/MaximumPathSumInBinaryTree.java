package StriverSheet.Day19;

import java.util.ArrayList;
import java.util.List;

///Problem: LC: 124 https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Solution : https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/

// Code self explanatory

public class MaximumPathSumInBinaryTree {

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum_helper(root, max);
        return max[0];
    }

    public static int maxPathSum_helper(TreeNode root, int[] max) {

        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSum_helper(root.left, max);
        int rightSum = maxPathSum_helper(root.right, max);

        int tempMaxA = Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
        int tempMaxB = Math.max(tempMaxA, root.val + leftSum + rightSum);
        max[0] = Math.max(max[0], tempMaxB);
        // Notice we are maintaining max[0] as max value at this root, but returning
        // either root, or, [ max (left arm, right arm) + root ]
        // this is because left+right+root cannot be returned as result for next
        // iteration
        return tempMaxA;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        int result = maxPathSum(root);// result : 262
        System.out.println(result);
    }

}
