package StriverSheet.Day20_BinarySearchTree;

// Problem: LC 98 https://leetcode.com/problems/validate-binary-search-tree/

// Approach 1 : Here we maintain 2 variables 'Min' and 'Max' as go deeper in the
// tree and keep comparing the current node with current min and current max.
// Min and Max keep narrowing as we go deeper in the tree

// Important Note: This method is not applicable if there are duplicate elements
// with the value INT_MIN or INT_MAX.
// Hence will NOT pass on Leetcode
// E.g. [-2147483648,-2147483648] <- Duplicate values of Min

// WORKAROUND is to use Long.MAX_VALUE and Long.MIN_VALUE

// Approach 2: Do InOrder traversal of the array. If it is sorted than it is BST.

public class ValidateBST {

    // Approach : 1
    public static boolean isValidBST_approach1(TreeNode root) {
        return isValidBST_app1__helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);// this will fail on Leetcode for
                                                                                   // input: [-2147483648,-2147483648]
        // return isValidBST_app1__helper(root, Long.MIN_VALUE, Long.MAX_VALUE); // this
        // will pass
    }

    public static boolean isValidBST_app1__helper(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.val > max || root.val < min) {
            return false;
        }

        return isValidBST_app1__helper(root.left, min, root.val - 1)
                && isValidBST_app1__helper(root.right, root.val + 1, max);
    }

    // Approach : 2
    public static boolean isValidBST_approach2(TreeNode root) {
        return isValidBST_approach2_helper(root);
    }

    static TreeNode prev; // Global variable

    public static boolean isValidBST_approach2_helper(TreeNode root) {
        if (root != null) {
            if (!isValidBST_approach2_helper(root.left)) {
                return false;

            }
            // if left tree node(prev node as it is inOrder) is greater than current node
            if (prev != null && prev.val >= root.val) {
                return false; // notice false is retuned
            }
            prev = root;

            if (!isValidBST_approach2_helper(root.right)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TreeNode root = TreeNode.PopulateBST();
        // boolean result = isValidBST_approach1(root);// approach 1
        TreeNode root = new TreeNode(0);
        boolean result = isValidBST_approach2(root); // approach 2
        System.out.println(result);
    }
}
