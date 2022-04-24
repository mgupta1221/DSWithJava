package PepLevelUp.LinkedList;

import java.util.ArrayList;

public class Basics_Day3 {

    private static Node ReverseSpecificNodes2(Node n, int left, int right) {
        if (n == null || n.next == null || right - left <= 0) {
            return n;
        }

        Node dummy = new Node(-1);
        dummy.next = n;

        Node current = dummy;
        Node previous = null;
        // For [1,2,3,4,5]   and left= 2, right =4
        // 'previous' will bceome 1 and current will be 2

        for (int i = 0; i < left; i++) {
            previous = current;
            current = current.next;
        }
        
        // Now reverse
        int nodeCount = right - left + 1;
        // preserving old previous and old current
        Node oldCurrent = current;
        Node oldPrevious = previous;
        int tempCount = 0;

        while (current != null && tempCount < nodeCount) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            tempCount++;
        }

        oldPrevious.next = previous;
        oldCurrent.next = current;
        return dummy.next;
    }

    // Find length of linked list
    private static int findLengthAndPrintToo(Node root) {
        if (root == null)
            return 0;

        int len = 0;
        while (root != null) {
            len++;
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        return len;

    }

    // Helper function to create a linked list
    private static Node LinkedListCreator(int[] values) {
        // Node is created in separate file "Node.java"
        Node root = new Node(values[0]);
        Node node = root;
        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            node.next = newNode;
            node = newNode;
        }
        return root;
    }

    public static void main(String[] args) {

        // LC 92
        int[] vals1 = new int[] { 2, 3 };
        Node head = LinkedListCreator(vals1);
        head = ReverseSpecificNodes2(head, 1, 2);
        findLengthAndPrintToo(head);

    }
}
