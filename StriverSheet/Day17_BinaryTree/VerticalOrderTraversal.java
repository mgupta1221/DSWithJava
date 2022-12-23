package StriverSheet.Day17_BinaryTree;

import java.util.*;

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
public class VerticalOrderTraversal {
    public static ArrayList<Integer> VerticalOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        TreeMap<Integer, List<Integer>> list = new TreeMap<Integer, List<Integer>>();

        verticalOrderTraversal_helper(root, list, 0);

        Collection<List<Integer>> values = list.values();

        Set<Integer> keys = list.keySet();
        for (int key : keys) {
            // and have to pull valyes using key (not index)
            String value = list.get(key).toString();
            System.out.println(key + " " + value);
        }

        return result;

    }

    public static void verticalOrderTraversal_helper(TreeNode root, TreeMap<Integer, List<Integer>> list,
            int hd) {

        if (root == null)
            return;

        // If key with value 'hd' is present ,than 'update' else 'add'
        List<Integer> mapAtHD = list.get(hd);

        // Store current node in map 'mapAtHd'
        if (mapAtHD == null) {
            mapAtHD = new ArrayList<>();
            mapAtHD.add(root.val);
        } else {
            mapAtHD.add(root.val);
        }
        
        list.put(hd, mapAtHD);

        if (root.left != null) {
            verticalOrderTraversal_helper(root.left, list, hd - 1);

        }
        if (root.right != null) {
            verticalOrderTraversal_helper(root.right, list, hd + 1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        ArrayList<Integer> result = VerticalOrderTraversal(root);
        for (int node : result) {
            System.out.println(node);
        }

    }
}
