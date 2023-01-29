package StriverSheet.Day6;

import StriverSheet.Day6.IntersectionOf2LL;
// LC: 25 https://leetcode.com/problems/reverse-nodes-in-k-group/

// Recursive Soluliton approach: https://www.youtube.com/watch?v=fi2vh0nQLi0 
// From 5:42 Sec
// In recursive approach - We reverse the first k elements(1st group) and assume that recursive call will reverse the rest of the elments and return the head of them (via "Prev" variable as seen in "Reversing a Linked list" solution). Now, we have to attach the returned "head" from the recursive call to "head.next" which is first element

public class ReverseNodesInKGroups {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = getLengthOfLinkedList(head);
        ListNode result = reverseKGroup_recur(head, k, len);
        return result;

    }

    public static ListNode reverseKGroup_recur(ListNode head, int k, int len) {

        // this below condition is very important to attach last remaining nodes(<k) to
        // the last group
        if (len < k) {
            return head;
        }

        // Step 1: Reverse first k nodes
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        int count = 0;
        while (current != null && count != k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        // Step 2: Recursion dekh lega, Notice we are reducing the length by len-k in
        // recursive call
        if (next != null)
            head.next = reverseKGroup_recur(next, k, len - k);

        // Step 3: Return Head of Returned List
        return prev;
    }

    // Get length of linked list
    public static int getLengthOfLinkedList(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = GetLinkedList(nums1);
        
        ListNode result = reverseKGroup(head1, 2);
        PrintLinkedList(result);
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
