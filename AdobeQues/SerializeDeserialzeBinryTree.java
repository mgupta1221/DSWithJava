package AdobeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Remmeber to use Queue to implement DFS in this solution

// Approach 1: Using recursion (simpler)
// Approach 2: Using DFS with Queue
// Point to note to implement this is - Always add "-1" to ArrayList for leaf nodes for Serialize(). 
// And Also handle -1 in "Deserialize()"

public class SerializeDeserialzeBinryTree {

    // Approach 1: Recursion
    public static void serialize_approach1(TNode root, ArrayList<Integer> A) {
        if (root == null) {
            A.add(-1);
            return;
        }

        A.add(root.val);
        serialize_approach1(root.left, A);
        serialize_approach1(root.right, A);
    }

    // Function to deserialize a list and construct the tree.
    public static TNode deSerialize_approach1(ArrayList<Integer> A) {
        if (A.size() == 0)
            return null;
        int val = A.get(0);
        A.remove(0); // removes element at index n
        if (val == -1) {
            return null;
        }
        TNode root = new TNode(val);
        root.left = deSerialize_approach1(A);
        root.right = deSerialize_approach1(A);
        return root;
    }

    // Approach 2: Using DFS
    public static void serialize_approach2(TNode root, ArrayList<Integer> A) {
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TNode node = q.poll();
            if (node == null) {
                A.add(-1);
                continue;
            }
            A.add(node.val);
            q.add(node.left);
            q.add(node.right);
        }

    }

    // Function to deserialize a list and construct the tree.
    public static TNode deSerialize_approach2(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return null;
        }

        Queue<TNode> q = new LinkedList<>();

        // Applying DFS
        TNode root = new TNode(A.get(0));
        q.add(root);
        // Iterate
        for (int i = 1; i < A.size(); i++) {
            TNode parent = q.poll();
            int item = A.get(i);
            // assigning left child and add to queue
            if (item != -1) {
                TNode n = new TNode(item);
                parent.left = n;
                q.add(n);
            }
            i++;
            item = A.get(i);
            // assigning right child and add to queue
            if (item != -1) {
                TNode n = new TNode(item);
                parent.right = n;
                q.add(n);
            }

        }
        return root;

    }

    public static void main(String[] args) {
        TNode root = TNode.PopulateBinaryTree();
        ArrayList<Integer> A = new ArrayList<>();

        // serialize_approach1(root, A);
        serialize_approach1(root, A);

        TNode root2 = deSerialize_approach2(A);
        TNode.PrintTree(root2);
    }

}
