package StriverSheet.Day21;

public class KthSmallest_Element_in_BST {
    // Problem: LC 230 https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    // Appraoch : Use InOrder

    public static int kthSmallest(TreeNode root, int k) {
        int result[] = new int[1];
        int counter[] = new int[1];
        kthSmallest_helper(root, k, counter, result);
        return result[0];

    }

    public static void kthSmallest_helper(TreeNode root, int k, int[] counter, int result[]) {
        if (root == null) {
            return;
        }
        kthSmallest_helper(root.left, k, counter, result);

        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }

        kthSmallest_helper(root.right, k, counter, result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();
        int result = kthSmallest(root, 3);
        System.out.println(result);

    }

}
