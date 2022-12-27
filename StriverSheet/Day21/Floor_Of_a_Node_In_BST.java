package StriverSheet.Day21;

// Problem: https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457

// Problem Statement :You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. 
// Your task is to find the greatest value node of the BST  which is smaller than or equal to  ‘X’.

// Solution : Check Finding (PreAnd_Succ) Predesccor and Successor Question in Day 20. This is on same pattern

public class Floor_Of_a_Node_In_BST {

    public static int floorInBST(TreeNode root, int X) {
        int[] result = new int[1];
        floorInBSThelper(root, X, result);
        return result[0];

    }

    public static void floorInBSThelper(TreeNode root, int X, int[] result) {
        if (root == null) {
            return;
        }
        floorInBSThelper(root.left, X, result);//left


        if (root != null && root.val <= X) { // Notice element should be less than or equal to
            result[0] = root.val;
        }

        floorInBSThelper(root.right, X, result);//right

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();

        int result = floorInBST(root, 30);
        System.out.println(result);

    }

}
