package GettingStartedBasics.BinaryTree;

public class IsBinarySearchTree {

    // Solution video:
    // https://www.youtube.com/watch?v=kMrbTnd5W9U&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=49

    // How to decide a tree is BST or not: Each node needs to maintain 3 props:
    // 1. Left child tree is a BST
    // 2. Right child tree is a BST
    // 3. Root of this tree should be grater than Max value of left child tree
    // 4. Root of this tree should be less than Min value of right child tree

    // We return a custom object BST with following properties
    public static class BST {
        boolean isBST;
        int min;
        int max;
    }

    private static BST IsBinarySearchTree(Node node) {
        if (node == null) {
            BST bst = new BST();
            bst.isBST = true;
            bst.max = Integer.MIN_VALUE;
            bst.min = Integer.MAX_VALUE;
            return bst;
        }

        BST leftTree = IsBinarySearchTree(node.left);

        BST rightTree = IsBinarySearchTree(node.right);

        BST mp = new BST();
        // Tree is BST if root node has following properties, if:
        // a. Its left tree is BST
        // b. Its right tree is BST
        // c. Its root node is greater than left tree's max value and less than right
        // tree's min value

        // Agar Left ka tree sahi hai , or Right ka tree sahi hai or Tum khud bhi sahi
        // ho ...to tum BST ho
        mp.isBST = leftTree.isBST && rightTree.isBST
                && node.val >= leftTree.max && node.val <= rightTree.min;

        // mujhe apne min or max calculate karne ke liye...mere left or right sub tree
        // ke min and max chahiye honge
        // mera khud ka(root node ka) min = Mere Left tree ka min, Mere Right tree ka
        // min aur Root node ka min
        mp.min = Math.min(node.val, Math.min(leftTree.min, rightTree.min));
        mp.max = Math.max(node.val, Math.max(leftTree.max, rightTree.max));

        return mp;
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        BST resultPair = IsBinarySearchTree(root);
        System.out.println(resultPair.isBST);

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
