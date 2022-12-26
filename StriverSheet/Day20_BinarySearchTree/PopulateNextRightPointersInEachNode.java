package StriverSheet.Day20_BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// Problem: LC 116 : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Approach 1: DFS

// Approach : Normal recursion

public class PopulateNextRightPointersInEachNode {

    // Appraoch 1 : DFS
    public static Node connect_appraoch1(Node root) {

        Queue<Node> st = new ArrayDeque<>();

        st.add(root);
        Node prev = new Node();// Using a temp Node 'prev' to keep track of left node in level order to join it
                               // with right node

        while (!st.isEmpty()) {
            int size = st.size();

            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    Node current = st.poll();
                    prev.next = current;
                    System.out.print(prev.val + "->" + prev.next.val);
                    if (current.left != null)
                        st.add(current.left);
                    if (current.right != null)
                        st.add(current.right);
                    prev = current;

                }
                System.out.println();
            }
            prev = new Node();
        }
        return root;
    }

    // Appraoch 2 : Recursion
    public static Node connect_appraoch2(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        connect_appraoch2_helper(root.left, root.right);
        return root;

    }

    public static void connect_appraoch2_helper(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;
        connect_appraoch2_helper(left.left, left.right);
        connect_appraoch2_helper(left.right, right.left);
        connect_appraoch2_helper(right.left, right.right);

    }

    public static void main(String[] args) {

        Node root = Node.PopulateBinaryTree();

        // connect_appraoch1(root);
        // printNext(root);// testing

        connect_appraoch2(root);
        printNext(root); // testing

    }

    public static void printNext(Node root) {
        if (root == null) {
            return;
        }

        if (root.next != null)
            System.out.println(root.val + " -> " + root.next.val);

        if (root.left != null) {
            printNext(root.left);
        }
        if (root.right != null) {
            printNext(root.right);
        }

    }

}
