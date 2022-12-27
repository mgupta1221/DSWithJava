package StriverSheet.Day21;

public class KthLargest_Element_in_BST {
    // Problem: LC
    // https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

    public static int kthLargest(TreeNode root, int k) {
        int result[] = new int[1];
        int counter[] = new int[1];
        kthLargest_helper(root, k, counter, result);
        return result[0];

    }

    public static void kthLargest_helper(TreeNode root, int k, int[] counter, int result[]) {
        if (root == null) {
            return;
        }
        kthLargest_helper(root.left, k, counter, result);

        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }

        kthLargest_helper(root.right, k, counter, result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();
        int result = kthLargest(root, 2);

    }

}
