package GettingStartedBasics.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPreandInOrder {

    // Leet code 105
    // Solution video:
    // https://www.youtube.com/watch?v=FBpQEQkQ1No

    // Example Diagram: ConstructTreeFromPreAndInOrder.png

    // Approach:
    // PreOrder start with root than go left and than right
    // so we can get the root from PreOrder array

    // Now if we see InOrder array, all left subtree elements of root will on the
    // left side of the root in the InOrder array and all right subtree elements
    // will be
    // on the right side of the root element E.g. 3 is the root [9] is on the left
    // side of 3 and [20,15,7] are on the
    // right side in InOrder array

    // So using this approach, we will get all roots from the PreOrder array and
    // left and right subtree from InOrder arratt recursively.
    // We will use 'start' and 'end' variable to populate left and right nodes of
    // root node recursively.

    // global variables

    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static Node buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Node root = buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
        return root;
    }

    public static Node buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // We will keep getting root from PreOrder array and notice we are incrementing
        // preIndex as well to get the next root node in the next recursive call
        Node root = new Node(preorder[preIndex++], null, null);

        // if this node has no children than return
        if (start == end) {
            return root;
        }

        // get the index of root element in InOrder array. Using this index, we will get
        // the left and right child nodes from InOrder array. Everything on the left
        // will left sub tree elements and same is true for right.
        int idx = map.get(root.val);

        root.left = buildTreeHelper(preorder, inorder, start, idx - 1);
        root.right = buildTreeHelper(preorder, inorder, idx + 1, end);
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root = buildTree(preorder, inorder);

        // validating the result
        PrintTreeInPreOrder(root);

    }

    private static void PrintTreeInPreOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.val + " -> ");
        if (root.left != null) {
            PrintTreeInPreOrder(root.left);

        }

        if (root.right != null) {
            PrintTreeInPreOrder(root.right);
        }

    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
