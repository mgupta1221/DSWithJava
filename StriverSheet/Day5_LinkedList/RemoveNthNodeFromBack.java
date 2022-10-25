package StriverSheet.Day5_LinkedList;
import StriverSheet.Day5_LinkedList.Add2NumbersAsLinkedList;

// LC: 19  https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromBack {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
        }

        previous.next = slow.next;
        return head;

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = GetLinkedList(nums1);

        ListNode head = removeNthFromEnd(head1, 2);
        PrintLinkedList(head);
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

