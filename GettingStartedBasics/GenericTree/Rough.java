package GettingStartedBasics.GenericTree;

import java.util.*;

public class Rough {
    private static void MirrorOftree(Node root) {

    }

    public static void main(String[] args) {
        Node root = PopulateTreeHelper();
        MirrorOftree(root);
    }

    public static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            this.val = data;
        }
    }

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
        root.children.add(new Node(35));
        root.children.add(child3);

        child2.children.add(child4);
        child2.children.add(child5);

        return root;
    }

}
