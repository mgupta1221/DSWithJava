package GettingStartedBasics.BinaryTree;

public class LargestBSTSubTree {

    // Solution video:
    // https://www.youtube.com/watch?v=UGsJz8fSYp0&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=53

    // Here, we will return following as result:
    // 1. Largest BST SubTree's root node
    // 2. Largest BST SubTree's size(no. of nodes)

    // We return a custom object BST with following properties
    public static class BST {
        boolean isBST;
        int min;
        int max;
        // adding 2 new properties whcih will form result
        Node root;
        int size;
    }

    private static BST FindLargestBSTSubTreeRootAndChild(Node node) {
        if (node == null) {
            BST bst = new BST();
            bst.isBST = true;
            bst.max = Integer.MIN_VALUE;
            bst.min = Integer.MAX_VALUE;
            bst.root = null;
            bst.size = 0;
            return bst;
        }

        BST leftTree = FindLargestBSTSubTreeRootAndChild(node.left);
        BST rightTree = FindLargestBSTSubTreeRootAndChild(node.right);

        BST mp = new BST();

        mp.isBST = leftTree.isBST && rightTree.isBST
                && node.val >= leftTree.max && node.val <= rightTree.min;

        // Imagine this tree is child of a parent node than what will be its min and max
        mp.min = Math.min(node.val, Math.min(leftTree.min, rightTree.min));
        mp.max = Math.max(node.val, Math.max(leftTree.max, rightTree.max));

        // additional steps start from here, above are same as were in
        // "IsBinarySearchTree" question
        // If root is BST
        if (mp.isBST) {
            mp.root = node;
            mp.size = leftTree.size + rightTree.size + 1;
        }
        // next go to the tree which has bigger size
        else if (leftTree.size > rightTree.size) {
            mp.root = leftTree.root;
            mp.size = leftTree.size;
        } else {
            mp.root = rightTree.root;
            mp.size = rightTree.size;
        }
        // If
        return mp;
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        BST resultPair = FindLargestBSTSubTreeRootAndChild(root);
        System.out.println(resultPair.root.val);

    }

    public static Node removeLeafNodes(Node root) {
        if (root == null) {

        }
        if (root.left == null && root.right == null) {

        }

        Node leftTree = removeLeafNodes(root.left);
        Node rightTree = removeLeafNodes(root.right);
        if (root.left == null && root.right == null) {

        }

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
