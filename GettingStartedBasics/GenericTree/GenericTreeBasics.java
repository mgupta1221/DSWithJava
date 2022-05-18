package GettingStartedBasics.GenericTree;

import java.util.ArrayList;

///Generic Tree Pepcoding Playlist 
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_

public class GenericTreeBasics {

    private static class Node {
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

        s += 1;// adding for the root itself
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
    // Depth of a node is its distance from the root.
    // Depth of the root node is 0, than first level nodes is 1...like that.
    // "Height of the tree" is the depth of the deepst node
    // E.g. Height of a tree with only root node is 0
    private int findHeightOfTree(Node root) {
        int tempMaxHeight = -1; // this is important because if the tree has only root node than
        // below last addition of +1 will make this 0 and return it which is the correct
        // ans.
        for (Node child : root.children) {
            int tempHeight = findHeightOfTree(child);
            tempMaxHeight = Math.max(tempMaxHeight, tempHeight);
        }
        return tempMaxHeight + 1;
    }

    public static void main(String[] args) {

    }
}
