package AdobeQues;

import StriverSheet.Day6.Node;

// Problem: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

public class ReverseLinkListInGroups {
    public static Node reverse(Node node, int k) {

        int len = getLengthOfLinkedList(node);
        return reverse_helper(node, k, len);

    }

    public static Node reverse_helper(Node node, int k, int len) {

        // Also, remove this condition if you also want to reverse the last pending
        // (less than k) nodes
        if (len < k) {
            return node;
        }

        Node prev = null;
        Node current = node;
        Node next = null;

        int count = 0;

        while (current != null && count != k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            node.next = reverse_helper(next, k, len - k);
        }
        return prev;
    }

    // Get length of linked list
    public static int getLengthOfLinkedList(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        Node head1 = GetLinkedList(nums1);

        Node result = reverse(head1, 3);
        PrintLinkedList(result);
    }

    public static Node GetLinkedList(int[] nums) {
        Node head = new Node(nums[0]);

        Node tempHead = head;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            tempHead.next = node;
            tempHead = node;
        }
        return head;
    }

    public static void PrintLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}
