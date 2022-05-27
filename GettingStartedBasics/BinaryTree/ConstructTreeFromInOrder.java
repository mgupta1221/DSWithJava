package GettingStartedBasics.BinaryTree;

public class ConstructTreeFromInOrder {
    
    // Solution Video:
    // https://www.youtube.com/watch?v=UAsLKuEMhsQ&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=56
    public static Node buildTreeFromInorder(int[] inorder) {

        int len = inorder.length - 1;
        Node root = buildTreeFromInorderHelper(inorder, 0, len);
        return root;
    }

    // In Order, the trick is we know that root nodes are in middle and all left
    // child nodes will
    // will be on the left side of it in the Inorder array[] and bigger nodes will
    // be on the right side
    public static Node buildTreeFromInorderHelper(int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder[mid], null, null);
        if (start == end) {
            return root;
        }
        root.left = buildTreeFromInorderHelper(inorder, start, mid - 1);
        root.right = buildTreeFromInorderHelper(inorder, mid + 1, end);
        return root;

    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root = buildTreeFromInorder(inorder);

        // validating the result
        PrintTreeInOrder(root);

    }

    private static void PrintTreeInOrder(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            PrintTreeInOrder(root.left);
        }
        System.out.print(root.val + " -> ");
        if (root.right != null) {
            PrintTreeInOrder(root.right);
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
