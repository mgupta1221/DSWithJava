package StriverSheet.Day21;

import java.util.ArrayList;
import java.util.HashMap;

public class Pair_With_Given_Sum_In_BST {

    // Problem : LC 653 https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

    // Solution:
    // Appraoch 1: Store the nodes in sorted arrayList using InOrder Traversal and
    // than searc for pair with required sum

    // Time Complexity: O(n).
    // Inorder Traversal of BST takes linear time.
    // Auxiliary Space: O(n).
    // Use of array for storing the Inorder Traversal.

    // Approach 2: Using hashMap
    // Approach 3: Using BST Iterator approach in another file

    // Approach 1 below first:
    public static boolean findTarget_approach1(TreeNode root, int k) {

        ArrayList<Integer> sortednodes = new ArrayList<>();
        findTarget_InOrder_helper(root, k, sortednodes);

        // See how we are searching pair in sorted arraylist
        int i = 0;
        int j = sortednodes.size() - 1;

        for (int p = 1; p < sortednodes.size(); p++) {
            int num1 = sortednodes.get(i);
            int num2 = sortednodes.get(j);
            if (num1 + num2 == k) {
                return true;
            } else if (num1 + num2 < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    // In Order traversal to store the nodes in sorted form
    public static void findTarget_InOrder_helper(TreeNode root, int k, ArrayList<Integer> sortednodes) {
        if (root == null) {
            return;
        }
        findTarget_InOrder_helper(root.left, k, sortednodes);

        sortednodes.add(root.val);
        findTarget_InOrder_helper(root.right, k, sortednodes);

    }

    // Approach 2: Using HashMap
    static HashMap<Integer, Integer> twoSum = new HashMap<>();

    public static boolean findTarget_approach2(TreeNode root, int k) {
        return twoSum(root, k);
    }

    public static boolean twoSum(TreeNode root, int k) {
        if (root == null)
            return false;

        if (twoSum.containsKey(k - root.val))
            return true;
        else
            twoSum.put(root.val, root.val);

        return twoSum(root.left, k) || twoSum(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();

        // boolean result = findTarget_approach1(root, 49); // Approach 1

        boolean result = findTarget_approach2(root, 49); // Approach 2
        System.out.println(result);

    }

}
