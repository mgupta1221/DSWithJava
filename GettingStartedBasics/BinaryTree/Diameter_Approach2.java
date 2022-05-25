package GettingStartedBasics.BinaryTree;

public class Diameter_Approach2 {

    // Solution for both approach 1 and 2:
    // https://www.youtube.com/watch?v=S0Bwgtn32uI&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=45

    // Approach 2
    // This is efficient than Approach 1 becuase of less recursive calls

    // isme return ek class object hoga..object hume height or diamter dono dega

    public static class DiaPair {
        int height;
        int dia;
    }

    private static DiaPair DiameterofBinaryTree(Node node) {
        if (node == null) {
            DiaPair pair = new DiaPair();
            pair.height = -1;
            pair.dia = 0;
            return pair;
        }

        // maxDistance between 2 nodes on left hand side
        DiaPair leftPair = DiameterofBinaryTree(node.left);

        // maxDistance between 2 nodes on right hand side
        DiaPair rightPair = DiameterofBinaryTree(node.right);

        // ye function khud bhi DiaPair return karega
        DiaPair mp = new DiaPair();

        mp.height = Math.max(leftPair.height, rightPair.height) + 1;
        // same 3 people max as it was in Approach 1
        int x1 = leftPair.height + rightPair.height + 2; // height from either side
        int x2 = leftPair.dia;
        int x3 = rightPair.dia;

        mp.dia = Math.max(x1, Math.max(x2, x3));
        return mp;
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        DiaPair resultPair = DiameterofBinaryTree(root);
        System.out.println(resultPair.dia);

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
