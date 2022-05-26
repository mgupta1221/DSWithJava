package GettingStartedBasics.BinaryTree;

public class IsBalancedTree {

    // Solution video:
    // https://www.youtube.com/watch?v=lUDgp2D6sf8&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=51

    // Baslanced tree is one in which every node's left tree height and right tree's
    // height is <=1
    // You can take absolute value of height of Left and right tree

    // Here to decide a tree is Balanced or not: Each node needs to maintain 3
    // props:
    // 1. Each node should be balanced
    // 2. Left tree height and right tree's height is <=1

    // function will return height and final rsult will be capatured in a Global
    // variable

    // Approch 1: Using Global Variable

    static boolean IsBalanced = true;

    private static int IsTreeBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int heghtLeft = IsTreeBalanced(node.left);
        int heghtRight = IsTreeBalanced(node.right);

        int NetHeight = Math.abs(heghtLeft - heghtRight);
        if (NetHeight > 1) {
            IsBalanced = false;
        }
        int nodeHeight = Math.max(heghtLeft, heghtRight) + 1;
        return nodeHeight;
    }

    // Approch 2: Using class object (without using Global varibale)

    public static class Pair {
        int height;
        boolean isBalanced;
    }

    public static Pair IsBalancedUsingPairObject(Node root) {
        if (root == null) {
            Pair basePair = new Pair();
            basePair.height = 0;
            basePair.isBalanced = true;
        }

        Pair leftTreePair = IsBalancedUsingPairObject(root.left);
        Pair rightTreePair = IsBalancedUsingPairObject(root.right);

        Pair myResult = new Pair();
        int pairHeight = Math.abs(leftTreePair.height - rightTreePair.height) + 1;
        boolean pairIsBalanced = Math.abs(leftTreePair.height - rightTreePair.height) <= 1
                && leftTreePair.isBalanced
                && rightTreePair.isBalanced;

        myResult.height = pairHeight;
        myResult.isBalanced = pairIsBalanced;
        return myResult;

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        IsTreeBalanced(root);// Using Global variable
        System.out.println(IsBalanced);

        Pair resultPair = IsBalancedUsingPairObject(root); // Without using global variable, using custom class obejct
        System.out.println(resultPair.isBalanced);

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
