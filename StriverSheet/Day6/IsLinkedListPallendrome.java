package StriverSheet.Day6;

import StriverSheet.Day6.IntersectionOf2LL;

// LC: 234 https://leetcode.com/problems/palindrome-linked-list/
// Solution:
// Step 1: Reach to the middle of the LL
// Step 2: Reverse the second part of the LL
// Step 3: Check if elements in first and second half are same

public class IsLinkedListPallendrome {
    public static boolean isPalindrome(ListNode head) {

        // Step 1:
        ListNode middleNode = findMiddleNode(head);

        // Step 2:
        ListNode headOfReversedList = reverseList(middleNode);

        // Step 3:
        while (head != null && headOfReversedList != null) {
            if (head.val != headOfReversedList.val) {
                return false;
            }
            head = head.next;
            headOfReversedList = headOfReversedList.next;
        }
        return true;

    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 5, 5, 2, 1 };
        ListNode head1 = GetLinkedList(nums1);

        Boolean result = isPalindrome(head1);

        System.out.println(result);
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
        System.out.println();
    }
}
