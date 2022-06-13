package GettingStartedBasics.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

public class NodesWithSingleChild {

    private static void PrintNodeWithSingleChild(Node root, ArrayList<Integer> arr) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.left == null || root.right == null) {
            arr.add(root.val);
        }

        PrintNodeWithSingleChild(root.left, arr);
        PrintNodeWithSingleChild(root.right, arr);
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        ArrayList<Integer> arr = new ArrayList<>();

        PrintNodeWithSingleChild(root, arr);

        // Short way to print ArrayList
        System.out.println(Arrays.deepToString(arr.toArray()));
        

    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(50, null, null);
        Node child1 = new Node(25, null, null);
        Node child2 = new Node(75, null, null);
        Node child3 = new Node(12, null, null);
        Node child4 = new Node(37, null, null);
        Node child5 = new Node(30, null, null);
        Node child7 = new Node(62, null, null);
        Node child8 = new Node(80, null, null);
        Node child9 = new Node(70, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;
        child2.right = child8;

        child7.right = child9;
        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
