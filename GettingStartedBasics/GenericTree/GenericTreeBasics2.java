package GettingStartedBasics.GenericTree;

import java.util.ArrayList;

///Generic Tree Pepcoding Playlist 
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_

public class GenericTreeBasics2 {

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            val = data;
        }
    }

    // find mirror of a tree
    private static void GetMirrorOfTree(Node root) {
        if (root == null)
            return;

        // recur for each child
        for (int i = 0; i < root.children.size(); i++) {
            GetMirrorOfTree(root.children.get(i));
        }

        int n = root.children.size();
        // Reverse the order of the elements in the children
        // 'i' variable will hold left most child, j will hold right most child and we
        // keep swapping
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node temp1 = root.children.get(i);
            Node temp2 = root.children.get(j);

            root.children.set(i, temp2); // set temp 2 at index i
            root.children.set(j, temp1);
        }

    }

    // Remove all leaf nodes of tree
    // Explanation
    // https://www.youtube.com/watch?v=uPOfEn_qHRY
    private static void RemoveLeaves(Node root) {
        if (root == null) {
            return;
        }

        if (root.children.size() == 0) {
            return;
        }

        // Notice we are running the loop from n-1 to 0 (not 0 to n-1)
        // Reason : https://www.youtube.com/watch?v=Us32OuAMzfQ
        // see above video from 15 mins to see when we ran the loop in reverse
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                root.children.remove(child);
            }
        }
        for (Node child : root.children) {
            RemoveLeaves(child);
        }
    }

    // Find an element in a tree
    // Explanation:
    // https://www.youtube.com/watch?v=dWri78Z4khs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=26
    private static Node FindElement(Node root, int val) {
        if (root.val == val) {
            return root;
        }
        for (Node child : root.children) {
            Node res = FindElement(child, val);
            if (res.val == val) {
                return res;
            }

        }
        return new Node(-1);
    }

    // Print Node to root path
    // Explanation:
    // https://www.youtube.com/watch?v=oEBwL5pHzTs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=28
    private static ArrayList<String> NodeToRootPath(Node root, int data) {

        // agar root mai mil gaya to nayi array list yahi se return kar do
        if (root.val == data) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(root.val + "-> ");
            return arr;
        }

        // Root mai nai mila to children mai dhoondh lo
        for (Node child : root.children) {
            ArrayList<String> pathToChild = NodeToRootPath(child, data);
            if (pathToChild.size() > 0) {
                pathToChild.add(root.val + "-> ");// Notice we add root here becuase its child has got an answr
                return pathToChild;
            }
        }
        // agar kahin nahi mila..na root mai na uske children mai
        return new ArrayList<>();
    }

    /// Helper to print and check the graph
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

        // Mirror a tree
        // InOrderTraversal(root);// this traversal is to test the mirrored tree before
        // and after
        // GetMirrorOfTree(root);
        // System.out.println();
        // InOrderTraversal(root);

        // Removing all leaves from tree
        // InOrderTraversal(root);
        // RemoveLeaves(root);
        // System.out.println();
        // InOrderTraversal(root);

        // Find Element in tree
        // Node result = FindElement(root, 50);
        // System.out.println(result.val);

        // Find Node to root path in tree
        ArrayList<String> result = NodeToRootPath(root, 50);
        for (String str : result) {
            System.out.print(str);
        }

    }
}
