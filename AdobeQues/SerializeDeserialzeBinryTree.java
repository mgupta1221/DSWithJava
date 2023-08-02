package AdobeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Remmeber to use Queue to implement DFS in this solution

public class SerializeDeserialzeBinryTree {

    public static void serialize(TNode root, ArrayList<Integer> A) {
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
    public static TNode deSerialize(ArrayList<Integer> A) {
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
        serialize2(root, A);

        TNode root2 = deSerialize2(A);
        TNode.PrintTree(root2);
    }

}
