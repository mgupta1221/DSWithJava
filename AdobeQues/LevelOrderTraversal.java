package AdobeQues;

import java.util.*;

// Level Order Traversal

public class LevelOrderTraversal {

    // Approach: DFS approach (RPA)
    // 1. Remove
    // 2. Print
    // 3. Addchildren

    // For printing each level in separate line we have used 2 queues.

    public static void printLevelOrder(TNode root) {

        Queue<TNode> mainQueue = new ArrayDeque<>();
        Queue<TNode> childQueue = new ArrayDeque<>();
        mainQueue.add(root);
        while (!mainQueue.isEmpty()) {
            TNode node = mainQueue.poll();
            System.out.print(node.val + " ");
            
            if (node.left != null)
                childQueue.add(node.left);
            if (node.right != null)
                childQueue.add(node.right);

            if (mainQueue.isEmpty()) {
                System.out.println();
                while (!childQueue.isEmpty()) {

                    TNode chilNode = childQueue.poll();
                    mainQueue.add(chilNode);
                }
            }

        }

    }

    public static void main(String[] args) {
        TNode T = TNode.PopulateBinaryTree();

        printLevelOrder(T);
    }
}
