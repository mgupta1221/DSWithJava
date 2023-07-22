package AdobeQues;

import java.util.*;

public class ConnectNodeAtSameLevel {

    // Approach: DFS approach (RPA)
    // 1. Remove
    // 2. Print
    // 3. Addchildren

    // For printing each level in separate line we have used 2 queues.

    // Solved with 2 approaches, both use DFS -

    // Approach 1: Fill all child nodes in current loop in arrayList and loop
    // ArrayList at the end to set nextRight property

    // Approach 2: Uses loop again but maintain a 'prev' node variable, initialized
    // with null. Keep setting it at each level with current node and set
    // 'nextRight' (if prev is not null)

    // Approach 1:
    public static void connect1(TNode root) {
        if (root == null)
            return;
        Deque<TNode> mainQueue = new ArrayDeque<>();

        mainQueue.add(root);
        while (!mainQueue.isEmpty()) {
            int count = mainQueue.size();
            ArrayList<TNode> arr = new ArrayList<>();
            for (int i = 0; i < count; i++) {

                TNode node = mainQueue.poll();

                arr.add(node);// fill arraylist

                if (node.left != null)
                    mainQueue.add(node.left);
                if (node.right != null)
                    mainQueue.add(node.right);
            }
            // loop arraylist to set nextRight property from 0 to n-2
            for (int i = 0; i <= arr.size() - 2; i++) {
                arr.get(i).nextRight = arr.get(i + 1);
            }
        }

    }

    // Approach 2
    public static void connect2(TNode root) {

        Queue<TNode> mainQueue = new ArrayDeque<>();

        mainQueue.add(root);
        while (!mainQueue.isEmpty()) {

            int size = mainQueue.size();
            TNode prev = null;
            for (int i = 0; i < size; i++) {

                TNode node = mainQueue.poll();

                if (prev != null) {
                    prev.nextRight = node;
                }
                prev = node;

                if (node.left != null)
                    mainQueue.add(node.left);
                if (node.right != null)
                    mainQueue.add(node.right);
            }
            prev.nextRight = null;
        }

    }

    public static void main(String[] args) {
        TNode root = TNode.PopulateBinaryTree();

        connect1(root);
        // connect2(root);
    }
}
