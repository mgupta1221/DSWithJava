package GettingStartedBasics.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeBasics1 {

    //
    // Consider "SampleBinaryTree.png" for sample tree
    private static void DisplayTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        DisplayTree(root.left);
        DisplayTree(root.right);

    }

    // Solution Video for next 4:
    // https://www.youtube.com/watch?v=I3D3p1TG1uE&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=4
    // Size means Number of nodes
    private static int SizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int sizeLeftTree = 0;
        int sizeRightTree = 0;
        if (root.left != null) {
            sizeLeftTree = SizeOfTree(root.left);

        }
        if (root.right != null) {
            sizeRightTree = SizeOfTree(root.right);
        }
        return sizeLeftTree + sizeRightTree + 1;

    }

    private static int SumOfTree(Node root) {

        if (root == null) {
            return 0;
        }
        int sumLeftTree = 0;
        int sumRightTree = 0;
        if (root.left != null) {
            sumLeftTree = SumOfTree(root.left);

        }
        if (root.right != null) {
            sumRightTree = SumOfTree(root.right);
        }
        return sumLeftTree + sumRightTree + root.val;

    }

    private static int MaxNodeOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int maxLeftTree = 0;
        int maxRightTree = 0;
        if (root.left != null) {
            maxLeftTree = MaxNodeOfTree(root.left);

        }
        if (root.right != null) {
            maxRightTree = MaxNodeOfTree(root.right);
        }
        return Math.max(maxLeftTree, Math.max(maxRightTree, root.val));

    }

    private static int HeightOfTree(Node root) {
        if (root == null) {
            return 0; // "-1" in case of edges , "0" in case of Nodes
        }
        int heightLeftTree = 0;
        int heightRightTree = 0;
        if (root.left != null) {
            heightLeftTree = HeightOfTree(root.left);

        }
        if (root.right != null) {
            heightLeftTree = HeightOfTree(root.right);
        }
        return Math.max(heightLeftTree, heightRightTree) + 1;

    }

    // SOlution Video:
    // https://www.youtube.com/watch?v=BuVNOAh33No&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=7
    private static void InOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            InOrderTraversal(root.left);

        }
        System.out.print(root.val + " -> ");
        if (root.right != null) {
            InOrderTraversal(root.right);
        }

    }

    // For Level Order: use RPA technique (DFS)
    // R: Remove
    // P: Print
    // A: Addition of children
    private static void LevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> dfsQueue = new ArrayDeque<>();

        dfsQueue.add(root);

        while (dfsQueue.size() > 0) {
            int count = dfsQueue.size();
            for (int index = 0; index < count; index++) {// This loop is to print each row in separate row
                                                         // else it is not needed if want to print in same line

                Node tempNode = dfsQueue.remove();
                System.out.print(tempNode.val + " ");
                if (tempNode.left != null) {
                    dfsQueue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    dfsQueue.add(tempNode.right);
                }
            }
            System.out.println();
        }

    }

    // Solution:
    // https://www.youtube.com/watch?v=1Kyc-zQS7eQ&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=17
    // This for Binary tree implementation is differnet compare to as done in
    // Generic tree
    // We are using Global arraylist here which we are populating from inside the
    // function.
    // In generic tree, we dont use any global arrayList
    private static boolean NodeToRootPath(Node root, int val, ArrayList<Integer> rootToNodePAth) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            rootToNodePAth.add(root.val);
            return true;
        }

        boolean resultLeft = NodeToRootPath(root.left, val, rootToNodePAth);
        if (resultLeft == true) {
            rootToNodePAth.add(root.val); // Notice we are adding root, not root.left
            return resultLeft;
        }

        boolean resultRight = NodeToRootPath(root.right, val, rootToNodePAth);
        if (resultRight == true) {
            rootToNodePAth.add(root.val);
            return resultRight;
        }
        return false;
    }

    // Solution video:
    // https://www.youtube.com/watch?v=KvcfuGcdDMg&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=22

    // here, we have to print all node at kth level
    private static void PrintKthLevelNodes(Node root, int k) {

        if (root == null || k < 0) {
            return;
        }
        //Print when recursively 'k' turns 0
        if (k == 0) {
            System.out.print(root.val + " ");
        }
        // Recrusive call for left and right with 1 level less
        PrintKthLevelNodes(root.left, k - 1);
        PrintKthLevelNodes(root.right, k - 1);
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        // DisplayTree(root);

        // int sizeResult = SizeOfTree(root);
        // System.out.println(sizeResult);

        // int sumResult = SumOfTree(root);
        // System.out.println(sumResult);

        // int maxResult = MaxNodeOfTree(root);
        // System.out.println(maxResult);

        // int heightResult = HeightOfTree(root);
        // System.out.println(heightResult);

        // InOrderTraversal(root);

        // LevelOrderTraversal(root);

        // ArrayList<Integer> rootToNodePAth = new ArrayList<>();
        // NodeToRootPath(root, 70, rootToNodePAth);
        // for (Integer n1 : rootToNodePAth) {
        // System.out.print(n1 + " ");
        // }

        PrintKthLevelNodes(root, 2);

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

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
