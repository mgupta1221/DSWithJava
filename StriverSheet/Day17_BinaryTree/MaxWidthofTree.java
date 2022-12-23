package StriverSheet.Day17_BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

// Problem:  https://leetcode.com/problems/maximum-width-of-binary-tree/

// Problem Description: 
// The maximum width of a binary tree is the maximum of all the level widths. Width for a level is defined as the maximum 
// number of nodes between the leftmost and rightmost node of the level(including the end nodes and the null nodes between the end nodes). 

// Solution Approach:  https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/

// Approach: 
// We use Level Order traversal approach using Queue
// If we index the tree as shown in the attached image(Refer: MaxWidthOfTree.jpg) we can easily calculate the width of
// the tree as rightMostNode – leftMostNode +1.
// Then we can return the maximum width as our answer. To store the index, we can use a pair(a class object) of values in our queue (that we use 
// for level order traversal). If we are at index i, then its left and right child are(in 0-based indexing): 2*i+1 and 2*i+2 respectively. 
// Please note that NULL nodes are not hampering the indexing in any way.

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode _node, int _level) {
        level = _level;
        node = _node;
    }
}

public class MaxWidthofTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        int max = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            max = Math.max(max, len); // to track maximum value after each iteration
            int left = 0;
            int right = 0;

            for (int i = 0; i < len; i++) {

                Pair current = queue.peek();
                queue.poll();

                if (i == 0) { // leftmost node at current level
                    left = current.level;
                }
                if (i == len - 1) {// rightmost node at current level
                    right = current.level;
                }

                if (current.node.left != null) {
                    queue.add(new Pair(current.node.left, 2 * current.level + 1)); // Notice how we are getting index of
                                                                                   // left child using parent index:
                                                                                   // (2*i)+1
                }
                if (current.node.right != null) {
                    queue.add(new Pair(current.node.right, 2 * current.level + 2)); // Right child: (2*i)+2
                }
            }
            max = Math.max(max, right - left + 1);

        }
        return max;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        int result = widthOfBinaryTree(root);
        System.out.println(result);
    }

}
