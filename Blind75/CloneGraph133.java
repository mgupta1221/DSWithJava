package Blind75;

import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph133 {

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraphHelper(node, map);
    }

    public static Node cloneGraphHelper(Node n, HashMap<Node, Node> map) {
        if (n == null)
            return null;
        if (map.containsKey(n))
            return map.get(n);
        Node newNode = new Node(n.val);
        map.put(n, newNode);

        for (Node neighbor : n.neighbors) {
            newNode.neighbors.add(cloneGraphHelper(neighbor, map));
        }
        return newNode;

    }

    public static void main(String[] args) {

        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect nodes (undirected)
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedGraph = cloneGraph(node1);

        // Print original and cloned graph for comparison
        System.out.println("Original Graph:");
        Node.printGraph(node1, new HashSet<>());

        System.out.println("\nCloned Graph:");
        Node.printGraph(clonedGraph, new HashSet<>());
    }
}
