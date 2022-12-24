package GettingStartedBasics.BinaryTree;

public class Diameter_Approach1 {

    // Solution for both approach 1 and 2:
    // https://www.youtube.com/watch?v=S0Bwgtn32uI&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=45

    // Approach 1
    // Easier solution but too many recursive calls
    // This approach uses height function as well which is also a recursive call. To
    // avoid those recursive calls for height we return both 'dia' and 'height' via
    // a class object. See DiamterOfTree2.java approach. Notice there are no
    // recursive calls in that implementation.
    private static int DiameterofBinaryTree(Node node) {
        if (node == null) {
            return 0;
        }

        // maxDistance between 2 nodes on left hand side
        int ld = DiameterofBinaryTree(node.left);

        // maxDistance between 2 nodes on right hand side
        int hd = DiameterofBinaryTree(node.right);

        // Notice we are using Height func here- this means:
        // max of (maxHeight of leftChild, MaxHeight of right Child) + 2 (for distance
        // from self till left and right child)
        int f = HeightOfTree(node.left) + HeightOfTree(node.right) + 2;

        // taking max of 3 values
        return Math.max(ld, Math.max(hd, f));
    }

    // Height of a Binary tree
    private static int HeightOfTree(Node node) {
        if (node == null) {
            return -1;// remember to return -1 (not 0) here becuase we need edge based height (not
                      // node based)
        }
        int leftTreeHeight = HeightOfTree(node.left);
        int rightTreeHeight = HeightOfTree(node.right);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        int diamter = DiameterofBinaryTree(root);
        System.out.println(diamter);

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
