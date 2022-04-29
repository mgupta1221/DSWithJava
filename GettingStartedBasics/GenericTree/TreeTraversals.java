package GettingStartedBasics.GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TreeTraversals {

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            val = data;
        }
    }

    private static void PreOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " "); // printing root first
        for (Node child : root.children) {
            PreOrderTraversal(child);
        }

    }

    // In Order
    // Solution :
    // https://www.geeksforgeeks.org/inorder-traversal-of-an-n-ary-tree/
    private static void InOrderTraversal(Node root) {
        if (root == null)
            return;

        for (int i = 0; i < root.children.size() - 1; i++) {            
            InOrderTraversal(root.children.get(i));
        }
        System.out.print(root.val + " "); // printing root
        if (root.children.size() > 0) {
            InOrderTraversal(root.children.get(root.children.size() - 1));
        }
    }

    // Post Order
    private static void PostOrderTraversal(Node root) {
        if (root == null)
            return;

        for (Node child : root.children) {
            PostOrderTraversal(child);
        }
        System.out.print(root.val + " "); // printing root at end

    }

    // Solution:
    // https://www.youtube.com/watch?v=TUxo5YpKvxw&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=13
    // Remember: RPA for DFS
    // r is Remove node
    // p is Print node
    // a is add Children
    private static void LevelOrderTraversal(Node root) {
        if (root == null)
            return;

        // Important how are declaring Queue in java
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            Node node = queue.remove();
            System.out.print(node.val + " ");

            for (Node child : node.children) {
                queue.add(child);
            }
        }

    }

    /// Print each level in different line in Level Order (Variation of Level order)
    // Approach 1
    // 10
    // 20 30 40
    // 50 60
    // THis solution will use 2 Queues
    // Soltuion:
    // https://www.youtube.com/watch?v=amG7xun8k4w&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=15
    private static void LevelOrderTraversalLineWise(Node root) {
        if (root == null)
            return;

        // Important how are declaring Queue in java
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();

        mainQueue.add(root);
        while (mainQueue.size() > 0) {
            Node node = mainQueue.remove();
            System.out.print(node.val + " ");
            for (Node n : node.children) {
                childQueue.add(n); // add children to Child queue
            }
            // Whn main queue is empty than line break(that means 1 level of tree is
            // complete)
            // and copy all elements from CQ to MQ...We are in while loop
            if (mainQueue.size() == 0) {
                System.out.println();
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
            }
        }

    }

    /// Print each level in different line in Level Order (Variation of Level order)
    // Approach w
    // 10
    // 20 30 40
    // 50 60
    // THis solution will use 1 Queue ONLY and we will add dummy node when a dummy
    /// node appears and
    // provided queue is not empty
    // Soltuion:
    // https://www.youtube.com/watch?v=NuASXwfaFaY&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=18
    private static void LevelOrderTraversalLineWise_Approach2(Node root) {
        if (root == null)
            return;

        // Important how are declaring Queue in java
        Queue<Node> mainQueue = new ArrayDeque<>();

        mainQueue.add(root);
        mainQueue.add(new Node(-99));

        while (mainQueue.size() > 0) {
            Node node = mainQueue.remove();
            if (node.val != -99) {
                System.out.print(node.val + " ");

                for (Node n : node.children) {
                    mainQueue.add(n); // add children to Child queue
                }
            } else {
                if (mainQueue.size() > 0) {// this check is important
                    mainQueue.add(new Node(-99));
                    System.out.println();
                }
            }

        }

    }

    // Helper to build tree
    public static Node PopulateTreeHelper() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(30);
        Node child3 = new Node(40);

        Node child4 = new Node(50);
        Node child5 = new Node(60);
        // Node child6 = new Node(70);
        // Node child7 = new Node(80);
        // Node child8 = new Node(90);
        // Node child9 = new Node(100);
        // Node child10 = new Node(110);
        // Node child11 = new Node(120);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        child2.children.add(child4);
        child2.children.add(child5);

        return root;
    }

    public static void main(String[] args) {

        Node root = PopulateTreeHelper();

        // PreOrderTraversal(root);
        // PostOrderTraversal(root);

        // Check logic for below 3
        InOrderTraversal(root);

        // LevelOrderTraversal(root);

        // LevelOrderTraversalLineWise(root);
        // LevelOrderTraversalLineWise_Approach2(root);

    }

}
