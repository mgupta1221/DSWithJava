package StriverSheet.Day17_BinaryTree;

import java.util.ArrayList;

public class PathToGivenNode {
    // Not available on leetcode

    public static int[] solve(TreeNode A, int B) {
        ArrayList<Integer> pathList = new ArrayList<>();
        solve_helper(A, B, pathList);
        int[] result = new int[pathList.size()];
        int i = 0;
        for (int n : pathList) {
            result[i++] = n;
        }
        return result;
    }

    // Notice this is returning boolean- we have to do this to track if path is
    // found
    public static boolean solve_helper(TreeNode A, int B, ArrayList<Integer> pathList) {
        if (A == null) {
            return false;
        }
        if (A.val == B) {
            pathList.add(A.val);
            return true;
        }

        boolean result = solve_helper(A.left, B, pathList);
        if (result) {
            pathList.add(A.val); // Notice this will not be 'A.left.val'
            return result;
        }

        result = solve_helper(A.right, B, pathList);
        if (result) {
            pathList.add(A.val); // Notice this will not be 'A.right.val'
            return result;
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.PopulateBinaryTree();
        int[] result = solve(root, 30);
        for (int n : result) {
            System.out.print(n + " ");
        }

    }

}
