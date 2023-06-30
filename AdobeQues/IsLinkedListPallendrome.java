package AdobeQues;

import StriverSheet.Day6.Node;

// LC: 234 https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
// Solution:
// Step 1: Reach to the middle of the LL
// Step 2: Reverse the second part of the LL
// Step 3: Check if elements in first and second half are same

public class IsLinkedListPallendrome {

    public static boolean isPalindrome(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node headOfreversedList = ReverseLL(slow);

        while (head != null && headOfreversedList != null) {
            if (head.val != headOfreversedList.val) {
                return false;
            }
            head = head.next;
            headOfreversedList = headOfreversedList.next;
        }
        return true;
    }

    public static Node ReverseLL(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        boolean result = isPalindrome(head);

        System.out.println(result);
    }
}
