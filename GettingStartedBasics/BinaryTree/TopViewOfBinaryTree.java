package GettingStartedBasics.BinaryTree;

import java.util.*;

// Solution Approach :
// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// This is not on LeetCode

//NOTE: Prerequisite Firt understand "Vertical order traversal" of a Binary Tree

// We will be using DFS to traverse the tree since we need Level Order and 
// we maintain HD(Horizontal distance) too as did in Vertical order traversal problem

// The only difference between this and Vertical Order is- Here We do not add
// further values to result once a value is added for 1 value of HD(Horizontal distance)
// which is the key in KeyValue pair, in case of Vertical Order traversal, we keep adding
//  the values for 1 key as each level order

public class TopViewOfBinaryTree {

    static class QueueObj {
        int hd;
        Node node;

        QueueObj(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Solution approach:
    public static ArrayList<Integer> TopViewOfTree(Node root) {
        if (root == null) {
            return null;
        }

        Queue<QueueObj> dfsQueue = new ArrayDeque<>();
        TreeMap<Integer, Node> treeMap = new TreeMap<>();

        QueueObj queueObj = new QueueObj(0, root);
        dfsQueue.add(queueObj);

        while (dfsQueue.size() > 0) {
            QueueObj currentObject = dfsQueue.poll();

            // The only difference between Vertical Order and Top View/Bottom View is that
            // there is no ELSE condition to add further values in the treeMap
            // since we are moving the tree from its root to the bottom
            // so when we fill the tree map for 'key'=HD, we do not have to fill it again
            if (!treeMap.containsKey(currentObject.hd)) {
                treeMap.put(currentObject.hd, currentObject.node);
            }

            // If left node exists, decrement HD and add to the DFSQueue
            if (currentObject.node.left != null) {
                QueueObj qObj = new QueueObj(currentObject.hd - 1, currentObject.node.left);
                dfsQueue.add(qObj);
            }

            // If right node exists,increment HD and add to the DFSQueue
            if (currentObject.node.right != null) {
                QueueObj qObj = new QueueObj(currentObject.hd + 1, currentObject.node.right);
                dfsQueue.add(qObj);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Node n1 : treeMap.values()) {
            System.out.print(n1.val + " ");
            result.add(n1.val);
        }

        return result;

    }

    public static void main(String[] args) {
        Node root = PopulateBinaryTree();

        TopViewOfTree(root);

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
