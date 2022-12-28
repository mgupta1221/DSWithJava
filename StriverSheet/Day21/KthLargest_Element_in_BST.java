package StriverSheet.Day21;

public class KthLargest_Element_in_BST {
    // Problem:
    // https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

    // First see Kth Smallest in BST question and solution .
    // The only chnage required in the solution is to do reverse InOrder traversal
    // by swapping left and right recursion calls

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
        kthLargest_helper(root.right, k, counter, result);

        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }

        kthLargest_helper(root.left, k, counter, result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();
        int result = kthLargest(root, 5);
        System.out.println(result);

    }

}
