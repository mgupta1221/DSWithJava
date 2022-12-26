package StriverSheet.Day20_BinarySearchTree;

// Problem: LC 108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class ConvertSortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;

        }
        return sortedArrayToBST_helper(nums, 0, nums.length - 1);

    }

    public static TreeNode sortedArrayToBST_helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode tempRoot = new TreeNode(nums[mid]);

        tempRoot.left = sortedArrayToBST_helper(nums, start, mid - 1);
        tempRoot.right = sortedArrayToBST_helper(nums, mid + 1, end);
        return tempRoot;

    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode result = sortedArrayToBST(nums);
        TreeNode.PrintTree(result);

    }

}
