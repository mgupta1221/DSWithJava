package GettingStartedBasics.GenericTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

///Generic Tree Pepcoding Playlist 
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_

public class GenericTreeBasics3 {

    // Are trees similar
    // Quesiton:
    // https://www.youtube.com/watch?v=rumfdyFR-_A&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=33
    // Solution :
    // https://www.youtube.com/watch?v=y_PIhsd9vt0&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=34

    // In this question, data of nodes se farq nahi padta...tree ka shape same hona
    // chhaiye
    private static boolean AreTreesSimilar(Node root1, Node root2) {
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            Node c1 = root1.children.get(i);
            Node c2 = root2.children.get(i);
            return AreTreesSimilar(c1, c2);
        }
        return true;
    }

    // Question:
    // https://www.youtube.com/watch?v=GfEQs3qhMws&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=35

    // Solution Video:
    // https://www.youtube.com/watch?v=v2MqQoma9uc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=36

    // In this question, data of nodes se farq nahi padta...tree ka shape same hona
    // chhaiye
    private static boolean AreTreesMirror(Node root1, Node root2) {
        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        int len1 = root1.children.size();

        for (int i = 0, j = len1 - 1; i < j; i++, j--) {
            Node c1 = root1.children.get(i);
            Node c2 = root1.children.get(j);
            return AreTreesMirror(c1, c2);
        }
        return true;

    }

    // Trees will be symetric if they are mirror of each other
    private static boolean AreTreesSymmetric(Node root1, Node root2) {
        return AreTreesMirror(root1, root2);
    }

    public static void main(String[] args) {

        Node root = PopulateTreeHelper();
        Node nodeCopy = new Node(root); // making a copy

        // nodeCopy.children.add(new Node(55));

        // boolean result = AreTreesSimilar(root, nodeCopy);
        // System.out.println(result);

        // boolean result = AreTreesMirror(root, nodeCopy);
        // System.out.println(result);

        boolean result = AreTreesSymmetric(root, nodeCopy);
        System.out.println(result);
    }

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            val = data;
        }

        // Cloning an object so that if changes are madein 1 , other should not get
        // affected
        public Node(Node another) {
            // For non primitives properties (like array, object),
            // always create new object like we did not below for arraylist children below
            ArrayList<Node> newChildren = new ArrayList<>();
            for (Node n : another.children) {
                newChildren.add(n);
            }
            this.children = newChildren; // you can access
        }
    }
    // Helper to print and check the graph

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

    // Helper to build tree
    public static Node PopulateTreeHelper() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(30);
        Node child3 = new Node(40);

        Node child4 = new Node(50);
        Node child5 = new Node(60);
        Node child6 = new Node(70);
        Node child7 = new Node(80);
        Node child8 = new Node(90);
        Node child9 = new Node(100);
        Node child10 = new Node(110);
        Node child11 = new Node(120);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        // child1.children.add(child4);
        // child1.children.add(child5);

        child2.children.add(child6);
        child2.children.add(child7);
        child2.children.add(child8);

        // child3.children.add(child9);

        child7.children.add(child10);
        child7.children.add(child11);

        return root;
    }

}
