package GettingStartedBasics.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeBasics2 {

    // Print all Paths from Root to leaf with total falling in a range
    /// Each path should be in a separate line
    // Solution Video:
    // https://www.youtube.com/watch?v=A6Z5YvsrDtg&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=29
    private static void PathFromRootToLeaf(Node root, int low, int high) {
        PathFromRootToLeafHelper(root, low, high, "", 0);

    }

    private static void PathFromRootToLeafHelper(Node root, int low, int high, String path, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum > low && sum < high) {
                System.out.println(path + " " + root.val);
            }
            return;
        }
        PathFromRootToLeafHelper(root.left, low, high, path + " " + root.val, sum + root.val);
        PathFromRootToLeafHelper(root.right, low, high, path + " " + root.val, sum + root.val);
    }

    // Solution video:
    // https://www.youtube.com/watch?v=TO7trQloRXc&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=33

    // Left clone means - every node will have its exact as left child.
    // E.g. Node 10 ke left mai Node 12 hai to result mai Node 10 ka lef child ek
    // new Node 10 hogi uska left child Node 12 hoga
    // See image: "LeftClone.png"
    private static Node TransformToLeftClone(Node root) {
        if (root == null) {
            return null;
        }
        // Assume 'a' as root node hai jiske child 'b' and 'c' hai
        Node leftClone = TransformToLeftClone(root.left);// assumption maante hue ki hame left or right child nodes ka
                                                         // resulting root node mil jayega with desrired result
                                                         // e.g. Leaf nodes ka leftClone and rightClone null hoga
        Node rightClone = TransformToLeftClone(root.right);
        Node newNode = new Node(root.val, leftClone, null);// new node is created with its left and right child, notice
                                                           // right child is null

        root.left = newNode; // root ka left ..new node ko point karega
        root.right = rightClone;// root ka right... seedha assign ho jayega
        return root;

    }

    // Solution Video:
    // https://www.youtube.com/watch?v=AvXVChZoZkU&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=38
    private static Node TransformFromLeftCloneToOriginal(Node root) {
        if (root == null) {
            return null;
        }
        Node leftNormalizedNode = TransformFromLeftCloneToOriginal(root.left.left);/// Notice we are calling for Left's
                                                                                   /// left
        Node rightNormalizedNode = TransformFromLeftCloneToOriginal(root.right);

        root.left = leftNormalizedNode;
        root.right = rightNormalizedNode;
        return root;
    }

    // Solution Video:
    // https://www.youtube.com/watch?v=x_0KUwgdm1c&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=42
    private static Node RemoveLeafNodes(Node node) {
        if (node == null) {
            return null;
        }
        // this is leaf node
        if (node.left == null && node.right == null) {
            return null; // aap leaf hain...to apni jagah null return kara dein
            // jab isme anadar code aayega tabhi node rmove hoga nahi to aage badh jayega
        }
        // assumption karenege ki agar left pe call karein to left node..saari nodes
        // delete karke hame nayi root dega
        // fir us result node ko apni node ke left mai laga dein

        // Notice how we assign result directly into node's left child
        // E.g. you are on Node 25(refer SampleBinaryTree.png), left child is 12 (which
        // is leaf) so 12 will be passed and result will come as null due to above
        // condiiton 'null' will be assigned at left side of 25 (node.left= ...)

        node.left = RemoveLeafNodes(node.left);
        node.right = RemoveLeafNodes(node.right);

        // return the node
        return node;

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        // PathFromRootToLeaf(root, 0, 100);

        // Node resultNode = TransformToLeftClone(root);
        // // PrintTreeInPreOrder(resultNode);

        // this is reverse of above
        // Node OriginalNode = TransformFromLeftCloneToOriginal(resultNode);
        // PrintTreeInPreOrder(OriginalNode);

        // Node resultrootNode = RemoveLeafNodes(root);
        // PrintTreeInPreOrder(resultrootNode);
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
