package GettingStartedBasics.GenericTree;

import java.util.ArrayList;

public class GenericTreeBasics {

    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // Size is total no of nodes in a tree
    private int sizeOfGenericTree(Node root) {

        int s = 0;
        for (Node child : root.children) {
            int result = sizeOfGenericTree(child);
            s = s + result;
        }
        s += 1;
        return s;

    }

    // Find max Node
    private int findMaxNode(Node root) {
        int max = Integer.MIN_VALUE;

        for (Node child : root.children) {
            int childMax = findMaxNode(child);
            max = Math.max(max, childMax);
        }
        max = Math.max(max, root.data);
        return max;

    }

    // Find Height of a Genertic tree
    private int findHeightOfTree(Node root) {
        // TO DO
        return 0;
    }

    public static void main(String[] args) {

    }
}
