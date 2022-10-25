package StriverSheet.Day6;

import StriverSheet.Day6.IntersectionOf2LL;

// LC: 141  https://leetcode.com/problems/linked-list-cycle/

public class DetectCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return slow == fast;

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle created here

        boolean result = hasCycle(head);
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
