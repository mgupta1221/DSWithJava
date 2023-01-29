package StriverSheet.Day5_LinkedList;

import StriverSheet.Day5_LinkedList.Add2NumbersAsLinkedList;


// LC: 206 https://leetcode.com/problems/reverse-linked-list/

// Maintain 3 variables-  Previous, Current and Next
// Maintain Previous and Current during iteration

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        return previous;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = GetLinkedList(nums);
        ListNode newHead = reverseList(head);
        PrintLinkedList(newHead);
    }

    // Helper Functions
    public static ListNode GetLinkedList(int[] nums) {
        ListNode head = new ListNode(nums[0]);

        ListNode tempHead = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            tempHead.next = node;
            tempHead = node;
        }
        return head;
    }

    public static void PrintLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

    }

}
