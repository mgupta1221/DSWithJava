package StriverSheet.Day17_BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

import StriverSheet.Day17_BinaryTree.TreeNode;

// Problem : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

// Approach : Dp a Level Order traversal and maintain a list that will store <CurrentLevel, Value>. 
// We will store the first value at level 'n' and ignore all other values at this level to get the Left View
// Solution Video https://www.youtube.com/watch?v=Lcre2oZh5YM
// This approach can be implemented by recursion or by using Queue as below

// Approach 1 : Level Order Traversal using Recursion

// Approach 2 : Level Order Traversal using DFS (Queue)

// TC for both approaches
// Time Complexity: O(N), where N is the number of nodes in the binary tree.
// Auxiliary Space: O(N) since using auxiliary space for queue

public class LeftAndRightViewOfTree {

    // Approach 1: Level Order Traversal using Recursion - First value at each level
    // will print the Left view of tree and Last Value at each level will print the Right View of Tree

    // Important: In this approach, below code is for Left view. For right view,
    // there are 2 ways we can achieve:

    // i) Either swap the leftSubtree and rightSubTree calls
    // ii) Remove the if condition and keep updating the values in HashMap, becuase
    // the last value will be part of right view
    static ArrayList<Integer> leftViewUsingRecursion(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();

        leftViewUtil(root, list, 0);

        Collection<Integer> values = list.values();
        for (int val : values) {
            result.add(val);
        }
        return result;

    }

    // Recursive helper
    static void leftViewUtil(TreeNode root, HashMap<Integer, Integer> list, int level) {
        // Base Case
        if (root == null)
            return;

        // For right view: remove the if condition and keep updating list with values
        if (list.get(level) == null) {
            list.put(level, root.val);
        }

        // Recur for left and right subtrees

        leftViewUtil(root.left, list, level + 1); // swap these 2 calls for right view
        leftViewUtil(root.right, list, level + 1);
    }

    // Appraoch 2: Level Order Traversal(DFS apporach) using Queue
    static ArrayList<Integer> leftViewUsingQueue(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode currentNode = queue.poll();

                // For right view - if current node is the last node of the current level, add
                // it to the result
                // For left view only change in if condition - if( i == 0 )
                if (i == len - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        ArrayList<Integer> result = leftViewUsingRecursion(root); // Approach 1

        // ArrayList<Integer> result = leftViewUsingQueue(root); // Approach 2

        for (int val : result) {
            System.out.println(val);
        }

    }
}
