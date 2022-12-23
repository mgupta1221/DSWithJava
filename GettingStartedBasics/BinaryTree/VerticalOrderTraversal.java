package GettingStartedBasics.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {

    // Solution approach:
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

    // Trick Diagram : VerticalOrderTraversal.png
    // This solution is not passing on Leetcode

    // Approach Description:
    // Here we assign Horizontal Distance (hd) from root to each node.
    // We can do preorder traversal of the given Binary Tree. While
    // traversing the tree, we can recursively calculate HDs. We initially pass the
    // horizontal distance as 0 for root. For left subtree, we pass the Horizontal
    // Distance as Horizontal distance of root minus 1. For right subtree, we pass
    // the Horizontal Distance as Horizontal Distance of root plus 1. For every HD
    // value, we maintain a list of nodes in a hash map. Whenever we see a node in
    // traversal, we go to the hash map entry and add the node to the hash map using
    // HD as a key in a map.
    // In this way, we will have a HashMap list at the end, with key as HD and
    // values as list of
    // nodes at that horiznatal distance(HD) from root node

    // Notice we are not using HashMap here but 'TreeMap' becuase TreeMap maintain
    // the
    // keys in a sorted manner. Irrespective of the key-insetion order

    // Also notice, how to print HashMap/TreeMap's key and values

    // Complexity : Time Complexity of this hashing based solution can be considered
    // as
    // O(n) under the assumption that we have good hashing function that allows
    // insertion and retrieval operations in O(1) time.

    public static List<List<Integer>> VerticalOrderTraversal(Node root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // recursive call to fill HashMap
        getVerticalOrder(root, map, 0);

        // Printing the filled map to show the output

        // notice you can pull 'keys' using keySet

        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            // and have to pull valyes using key (not index)
            String value = map.get(key).toString();
            System.out.println(key + " " + value);
        }

        return result;
    }

    public static void getVerticalOrder(Node node, TreeMap<Integer, List<Integer>> map, int hd) {
        if (node == null) {
            return;
        }
        // get the vector list at 'hd'
        List<Integer> mapAtHD = map.get(hd);

        // Store current node in map 'mapAtHd'
        if (mapAtHD == null) {
            mapAtHD = new ArrayList<>();
            mapAtHD.add(node.val);
        } else {
            mapAtHD.add(node.val);
        }
        map.put(hd, mapAtHD);

        // Store nodes in left subtree
        getVerticalOrder(node.left, map, hd - 1);
        // Store nodes in right subtree
        getVerticalOrder(node.right, map, hd + 1);

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        VerticalOrderTraversal(root);

    }

    public static Node PopulateBinaryTree() {
        Node root = new Node(3, null, null);
        Node child1 = new Node(9, null, null);
        Node child2 = new Node(20, null, null);
        Node child3 = new Node(15, null, null);
        Node child4 = new Node(7, null, null);

        root.left = child1;
        root.right = child2;

        child2.left = child3;
        child2.right = child4;

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
