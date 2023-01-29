package StriverSheet.Day5_LinkedList;
import StriverSheet.Day5_LinkedList.Add2NumbersAsLinkedList;


// LC: 876 https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = GetLinkedList(nums);
        ListNode middleNode = middleNode(head);
        System.out.println(middleNode.val);
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

