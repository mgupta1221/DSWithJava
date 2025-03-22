package Blind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Helper Node class for graph
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static void printGraph(Node node, HashSet<Node> visited) {
        if (node == null || visited.contains(node))
            return;

        visited.add(node);
        System.out.print("Node " + node.val + " neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

}