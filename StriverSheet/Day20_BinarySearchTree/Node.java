package StriverSheet.Day20_BinarySearchTree;

// Refer TreeImageForReference.png in this folder
public class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = null;
    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(50, null, null);
        Node child1 = new Node(25, null, null);
        Node child2 = new Node(75, null, null);
        Node child3 = new Node(12, null, null);
        Node child4 = new Node(37, null, null);
        Node child5 = new Node(30, null, null);
        Node child7 = new Node(45, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        return root;
    }

    public static void PrintTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        if (root.left != null)
            System.out.print("Left Child: " + root.left.val + " ,");
        if (root.right != null)
            System.out.print("Right Child: " + root.right.val + " ");
        System.out.println();
        PrintTree(root.left);
        PrintTree(root.right);

    }

}