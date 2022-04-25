package PepLevelUp.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;

public class Basics_Day3 {

    // LC 92 - Reverse a linked list in between nodes
    private static Node ReverseSpecificNodes(Node n, int left, int right) {
        if (n == null || n.next == null || right - left <= 0) {
            return n;
        }

        Node dummy = new Node(-1);
        dummy.next = n;

        Node current = dummy;
        Node previous = null;
        // For [1,2,3,4,5] and left= 2, right =4
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

    // LC 817 - Linked list components

    private static int numComponents(Node head, int[] nums) {

        if (head == null)
            return 0;
        HashSet<Integer> hashset = new HashSet<>();
        for (int n : nums) {
            hashset.add(n);
        }
        int numComps = 0;
        while (head != null) {

            // Notice "!hashset" in the second condition below because this condition is to
            // find when to break the series i.e. either we reached the end of the node ,
            // or, the next element is not in the dictionary
            if (hashset.contains(head.val) && (head.next == null ||
                    !hashset.contains(head.next.val))) {
                numComps++;
            }
            head = head.next;
        }
        return numComps;
    }

    // LC 141 - Has Cycle - I
    public static boolean hasCycle(Node head) {

        if (head == null || head.next == null)
            return false;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Note we are NOT comparing values of Node, but entire nodes itself
            if (slow == fast) {
                break;
            }
        }

        return slow == fast;

    }

    // LC 142 - Has Cycle II
    // Also known Flyod's cycle detection algorithm
    // This algorithm is to find the starting of the loop unlike the above one

    // A-> B -> C -> D
    // ........ |... |
    // .........F <- E

    // Notice theere is a cycle C-D-E-F ..this below algorithm helps in finding
    // Node 'C'

    public static Node hasCycle_II(Node head) {

        if (head == null || head.next == null)
            return null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Note we are NOT comparing values of Node, but entire nodes itself
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    // LC 160 -Intersection of Two Linked Lists
    // Approach 1: Get the length of both linked list and subtract the larger length
    // with smaller to get the delta
    // Move the larger LL delta times and now loop till you find the common node
    public static Node GetIntersection_Approach1(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        Node itr1 = head1;
        Node itr2 = head2;
        int lengthOfFirstLL = 0;
        while (itr1 != null) {
            itr1 = itr1.next;
            lengthOfFirstLL++;
        }
        int lengthOfSecondLL = 0;
        while (itr2 != null) {
            itr2 = itr2.next;
            lengthOfSecondLL++;
        }
        int delta = Math.abs(lengthOfFirstLL - lengthOfSecondLL);
        itr1 = head1;
        itr2 = head2;
        if (lengthOfFirstLL > lengthOfSecondLL) {
            for (int i = 0; i < delta; i++) {
                itr1 = itr1.next;
            }

        } else {
            for (int i = 0; i < delta; i++) {
                itr2 = itr2.next;
            }
        }
        // This node comparision below will not work locally but will work on leetcode
        while (itr1 != itr2) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        return itr1;

    }

    // Approach 1: Get the end of one linked list and point the end to that LL to
    // the head of another linked list and use the Flyod Cycle detection technique
    // to find the intersection point
    public static Node GetIntersection_Approach2(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        Node tail1 = head1;
        Node itr2 = head2;

        // finding tail of one linked list
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        tail1.next = itr2;

        Node intersectingNode = hasCycle_II(head1);
        tail1.next = null;// resetting the first LL's tail back to null(original state)
        return intersectingNode;

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
        // int[] vals1 = new int[] { 2, 3 };
        // Node head = LinkedListCreator(vals1);
        // head = ReverseSpecificNodes(head, 1, 2);
        // findLengthAndPrintToo(head);

        // LC 817. Linked List Components
        // int[] vals1 = new int[] { 0, 1, 2, 3, 4 };
        // Node head = LinkedListCreator(vals1);
        // int[] nums = new int[] { 0, 3, 1, 4 };
        // int result = numComponents(head, nums);
        // System.out.println(result);

        // LC - 141
        // Node n1 = new Node(3);
        // Node n2 = new Node(2);
        // Node n3 = new Node(0);
        // Node n4 = new Node(-4);
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n2; // creating cycle

        // Boolean result = hasCycle(n1);
        // System.out.println(result);

        // LC - 142 - Finding starting of the loop in a Cyclic linked list
        // Node n1 = new Node(3);
        // Node n2 = new Node(2);
        // Node n3 = new Node(0);
        // Node n4 = new Node(-4);
        // n1.next = n2;
        // n2.next = n3;
        // n3.next = n4;
        // n4.next = n2; // creating cycle

        // Node node = hasCycle_II(n1);
        // System.out.println(node.val);

        // LC 160. Intersection of Two Linked Lists
        // Solved with 2 approaches
        int[] vals1 = new int[] { 4, 1, 8, 4, 5 };
        Node head1 = LinkedListCreator(vals1);

        int[] vals2 = new int[] { 5, 6, 1, 8, 4, 5 };
        Node head2 = LinkedListCreator(vals2);

        // Node resultNode = GetIntersection_Approach1(head1, head2);
        Node resultNode = GetIntersection_Approach2(head1, head2);
        System.out.println(resultNode.val);

    }
}
