package GettingStartedBasics.BinaryTree;

import java.util.*;

// Question : 
// https://www.geeksforgeeks.org/find-all-root-to-leaf-path-sum-of-a-binary-tree/

public class Path_AllPathsConcatenated {

    private static void GetAllConcetantedPathstoLeaf(Node root) {
        ArrayList<Integer> allPaths = new ArrayList<>();
        GetAllConcetantedPaths_Helper(root, 0, allPaths);

        for (int path : allPaths) {
            System.out.println(path);
        }
        // return sum;
    }

    private static void GetAllConcetantedPaths_Helper(Node root, int currentPathSum, ArrayList<Integer> allPaths) {
        if (root == null) {
            return;
        }

        // if node is not null, Adding the current node value to the sum
        currentPathSum = (currentPathSum * 10) + root.val;

        if (root.left == null && root.right == null) {
            allPaths.add(currentPathSum);
            return;
        }

        GetAllConcetantedPaths_Helper(root.left, currentPathSum, allPaths);
        GetAllConcetantedPaths_Helper(root.right, currentPathSum, allPaths);
    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();
        GetAllConcetantedPathstoLeaf(root);
    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(1, null, null);
        Node child1 = new Node(2, null, null);
        Node child2 = new Node(3, null, null);
        Node child3 = new Node(15, null, null);
        Node child4 = new Node(7, null, null);

        root.left = child1;
        root.right = child2;

        // child2.left = child3;
        // child2.right = child4;

        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}