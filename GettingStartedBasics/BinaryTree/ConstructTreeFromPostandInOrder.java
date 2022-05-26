package GettingStartedBasics.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPostandInOrder {

    // Solution video for PreOrder:(same approach, just that we scan PostOrder array
    // from reverse as we collect root node from post Order and child trees from
    // InOrder array )
    // https://www.youtube.com/watch?v=FBpQEQkQ1No

    // See this quesiton first - ConstructTreeFromPreandInOrder.java

    // global variables

    static int postIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static Node buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // everything is same as explained inPreorder question, we just need to move in
        // reverse order, hence below line
        postIndex = inorder.length - 1;
        Node root = buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
        return root;
    }

    public static Node buildTreeHelper(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node root = new Node(postorder[postIndex--], null, null);

        // if this node has no children than return
        if (start == end) {
            return root;
        }
        int idx = map.get(root.val);

        // THIS IS IMPORTANT- YOU HAVE TO POPULATE RIGHT NODE FIRST
        root.right = buildTreeHelper(postorder, inorder, idx + 1, end);
        root.left = buildTreeHelper(postorder, inorder, start, idx - 1);
        
        return root;
    }

    public static void main(String[] args) {

        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root = buildTree(postorder, inorder);

        // validating the result
        PrintTreeInPostOrder(root);

    }

    private static void PrintTreeInPostOrder(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            PrintTreeInPostOrder(root.left);
        }
        if (root.right != null) {
            PrintTreeInPostOrder(root.right);
        }
        System.out.print(root.val + " -> ");

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
