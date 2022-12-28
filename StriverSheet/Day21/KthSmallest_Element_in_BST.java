package StriverSheet.Day21;

public class KthSmallest_Element_in_BST {
    // Problem: LC 230 https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    // Appraoch : Use InOrder traversal

    public static int kthSmallest(TreeNode root, int k) {
        // We are keeping arrays below (and not primitive variables) as we want the
        // values to persist in recursive calls
        int result[] = new int[1]; // to store the result
        int counter[] = new int[1]; // keeping a counter
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
