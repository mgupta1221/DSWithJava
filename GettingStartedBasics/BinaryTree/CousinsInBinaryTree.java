package GettingStartedBasics.BinaryTree;

import java.util.*;

// Leetcode :993
// Question : 
// https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/

public class CousinsInBinaryTree {

    private static boolean AreCousins(Node root, int x, int y) {
        int d1 = GetDepth(root, x, 0);
        int d2 = GetDepth(root, y, 0);
        // System.out.println(AreSiblings(root, x, y));

        // same height and diff parent
        return (d1 == d2) && !AreSiblings(root, x, y);

    }

    private static int GetDepth(Node root, int x, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            return depth;
        }
        int L = GetDepth(root.left, x, depth + 1);

        // if depth found in Left than return
        if (L != 0) {
            return L;
        }
        return GetDepth(root.right, x, depth + 1);

    }

    private static boolean AreSiblings(Node root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {

            if ((root.left.val == x && root.right.val == y) ||
                    (root.left.val == y && root.right.val == x)) {
                return true;
            }
        }
        return AreSiblings(root.left, x, y) || AreSiblings(root.right, x, y);
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        boolean result = AreCousins(root, 5, 4);
        System.out.println(result);
    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(1, null, null);
        Node child1 = new Node(2, null, null);
        Node child2 = new Node(3, null, null);
        Node child3 = new Node(4, null, null);
        Node child4 = new Node(5, null, null);

        root.left = child1;
        root.right = child2;
        child1.right = child3;
        child2.right = child4;

        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}