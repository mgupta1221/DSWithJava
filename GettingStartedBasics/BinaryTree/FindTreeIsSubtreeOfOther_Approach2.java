package GettingStartedBasics.BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Question Leetcode 572 : 
// O(n) solution

// With Approach 2 (Optimized): 
// https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/?ref=rp

// other approach is find preOrder and InOrder of both mainTree and SubTree
// 

public class FindTreeIsSubtreeOfOther_Approach2 {

    private static void getInOrder(Node root, List<Integer> arr) {

        if (root == null) {
            arr.add(-99);
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.val);
        getInOrder(root.right, arr);
    }

    private static void getPreOrder(Node root, List<Integer> arr) {
        if (root == null) {
            arr.add(-99);
            return;
        }
        arr.add(root.val);
        getPreOrder(root.left, arr);
        getPreOrder(root.right, arr);
    }

    private static boolean isSubTree(Node root1, Node root2) {
        // Get PreOrder for both trees
        List<Integer> arr1 = new ArrayList<>();
        getPreOrder(root1, arr1);

        List<Integer> arr2 = new ArrayList<>();
        getPreOrder(root2, arr2);

        // boolean result = checkIfPreOrInOrderIsSubSet(arr1, arr2);
        // if (result == false) {
        //     return false;
        // }
        System.out.println("Now In Order:");


        // Now Get InOrder for both trees
        arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        for (Integer integer : arr1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : arr2) {
            System.out.print(integer + " ");
        }

        return checkIfPreOrInOrderIsSubSet(arr1, arr2);

    }

    // Check "hay and needle" method to check if one String or List is subset of
    // another
    private static boolean checkIfPreOrInOrderIsSubSet(List<Integer> arr1, List<Integer> arr2) {
        if (arr2.size() == 0) {
            return true;
        }
        if (arr1.size() == 0) {
            return false;
        }
        for (int i = 0; i < arr1.size() - arr2.size(); i++) {
            if (arr1.get(i) == arr2.get(i)) {
                int j = 0;
                for (; j < arr2.size(); j++) {
                    System.out.println(arr1.get(i + j) + " " + arr2.get(j));
                    if (arr1.get(i + j) != arr2.get(j)) {
                        break;
                    }
                }
                if (j == arr2.size() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root1 = PopulateBinaryTree1(); // trees are same which are given in GFG link
        Node root2 = PopulateBinaryTree2();
        boolean result = isSubTree(root1, root2);
        System.out.println(result);
    }

    public static Node PopulateBinaryTree1() {
        Node root = new Node(10, null, null);
        Node child1 = new Node(4, null, null);
        Node child2 = new Node(16, null, null);
        Node child3 = new Node(3, null, null);
        Node child4 = new Node(20, null, null);

        root.left = child1;
        root.right = child2;
        child1.left = child3;
        child2.right = child4;

        return root;
    }

    public static Node PopulateBinaryTree2() {
        Node root = new Node(10, null, null);
        Node child1 = new Node(4, null, null);
        Node child2 = new Node(16, null, null);
        Node child3 = new Node(3, null, null);

        root.left = child1;
        root.right = child2;
        child1.left = child3;

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