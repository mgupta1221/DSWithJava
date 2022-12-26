package StriverSheet.Day19;

import java.util.ArrayList;
import java.util.*;

// Problem : LC 158 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Youtube: Using Stack DFS: https://www.youtube.com/watch?v=vssbwPkarPQ

// Approach 1 : 
// Youtube: DFS type appraoch but with Stack: https://www.youtube.com/watch?v=vssbwPkarPQ
// For Node x , we will push right child first to the stack and than push the Left Child becuase we want to
// process left child order first(need to do PreOrder processing)
// Than, get the latest inserted node in stack and make it the right child. Make sure not to pop that node from stack
// as we have to process its children later in the netx iteration. Also,, make the left child null as given in the quesiton.

// Approach 2 : 
// Youtube: Using Recursion: https://www.youtube.com/watch?v=sWf7k1x9XR4
// Go to the extreme bottom right node of the tree and than process
// TC = O(N), N is the height of tree

public class FlattenBinaryTreeToLinkedList {
    public static void flatten_appraoch1(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode currentNode = st.pop();
            if (currentNode.right != null) {
                st.push(currentNode.right);
            }
            if (currentNode.left != null) {
                st.push(currentNode.left);
            }

            if (!st.isEmpty()) {
                currentNode.right = st.peek();
            }

            currentNode.left = null;
        }
    }

    // Approach 2:
    static TreeNode prev = null; // global variable. Can be made local with a helper func approach

    public static void flatten_appraoch2(TreeNode root) {
        if (root == null)
            return;
        flatten_appraoch2(root.right); // going to extreme right with recursion and than process
        flatten_appraoch2(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();

        // flatten_appraoch1(root);

        flatten_appraoch2(root);

        TreeNode.PrintTree(root);// just printing
    }

}
