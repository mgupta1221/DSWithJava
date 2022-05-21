package GettingStartedBasics.GenericTree;

import java.util.*;

public class Rough {
    private static void MirrorOftree(Node root) {
        if (root == null) {
            return;
        }

        // recur for each child
        for (int i = 0; i < root.children.size(); i++) {
            MirrorOftree(root.children.get(i));
        }

        int len = root.children.size();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            var node1 = root.children.get(i);
            var node2 = root.children.get(j);
            root.children.set(j, node1);
            root.children.set(i, node2);
        }
    }

    private static void PrintPreOrderOfTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            PrintPreOrderOfTree(root.children.get(i));
        }
    }

    private static void RemoveLeafs(Node root) {
        if (root == null) {
            return;
        }
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                root.children.remove(child);
            }
        }

        // recur for each child
        for (int i = 0; i < root.children.size(); i++) {
            RemoveLeafs(root.children.get(i));
        }

    }

    private static ArrayList<String> NodeToRootpath(Node root, int val) {
        if (root.val == val) {

            ArrayList<String> result = new ArrayList<>();
            result.add(root.val + "->");
            return result;
        }
        for (int i = 0; i < root.children.size(); i++) {
            ArrayList<String> tempResult = NodeToRootpath(root.children.get(i), val);
            if (tempResult.size() > 0) {
                tempResult.add(root.val + "->");
                return tempResult;
            }
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        Node root = PopulateTreeHelper();
        // MirrorOftree(root);

        // PrintPreOrderOfTree(root);
        // Node resultNode = FindElement(root, 60);
        // System.out.println(resultNode.val);

        ArrayList<String> result = NodeToRootpath(root, 60);

        for (String str : result) {
            System.out.print(str);
        }
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
