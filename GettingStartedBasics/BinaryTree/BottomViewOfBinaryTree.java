package GettingStartedBasics.BinaryTree;

import java.util.*;

// Solution Approach :
// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// This is not on LeetCode

//NOTE: Prerequisite Firt understand "Vertical order traversal" and "Top View" of a Binary Tree

public class BottomViewOfBinaryTree {

    static class QueueObj {
        int hd;
        Node node;

        QueueObj(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Solution approach:
    public static ArrayList<Integer> BottomViewOfTree(Node root) {
        if (root == null) {
            return null;
        }

        Queue<QueueObj> dfsQueue = new ArrayDeque<>();
        TreeMap<Integer, Node> treeMap = new TreeMap<>();

        QueueObj queueObj = new QueueObj(0, root);
        dfsQueue.add(queueObj);

        while (dfsQueue.size() > 0) {
            QueueObj currentObject = dfsQueue.poll();

            // The only difference between Top View and Bottom View is that
            // There is no 'if' condition below
            // since we are moving the tree from its top to the bottom , and, also bottom
            // view is to look the tree from leaves side
            // so we keep updating the treeMap for 'key'=HD with new occurence because
            // we need the last node that appeared for HD value
            treeMap.put(currentObject.hd, currentObject.node);

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

        BottomViewOfTree(root);

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
