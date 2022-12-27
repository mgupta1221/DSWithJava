package StriverSheet.Day21;

// Problem: https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464

// Problem Statement : Ceil of an integer is the closest integer greater than or equal to a given number.
// For example:
// arr[] = {1, 2, 5, 7, 8, 9}, key = 3.
// The closest integer greater than 3 in the given array is 5. So, its ceil value in the given array is 5.

// Solution : Check Finding (Pre_And_Succ) Predesccor and Successor Question in Day 20. This is on same pattern

public class Ciel_Of_a_Node_In_BST {

    public static int findCeil(TreeNode root, int X) {
        int[] result = new int[1];
        findCeil_helper(root, X, result);
        return result[0];

    }

    public static void findCeil_helper(TreeNode root, int X, int[] result) {
        if (root == null) {
            return;
        }
        findCeil_helper(root.left, X, result);

        if (root != null && root.val >= X) {
            if ((result[0] == 0) || (result[0] != 0 && result[0] > root.val))
                result[0] = root.val;
        }

        findCeil_helper(root.right, X, result);

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();

        int result = findCeil(root, 30);
        System.out.println(result);

    }

}
