package StriverSheet.Day5_LinkedList;

// LC: 2 https://leetcode.com/problems/add-two-numbers/

// Problem:  The digits are stored in reverse order, and each of their nodes contains
// a single digit. Add the two numbers and return the sum as a linked list.

public class Add2NumbersAsLinkedList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead1 = (l1);
        ListNode newHead2 = (l2);
        ListNode resultList = new ListNode(-1);
        ListNode itr = resultList;
        int carry = 0;
        while (newHead1 != null || newHead2 != null || carry != 0) {
            int sum = carry + (newHead1 != null ? newHead1.val : 0) + (newHead2 != null ? newHead2.val : 0);
            int digitSum = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digitSum);
            itr.next = newNode;
            itr = itr.next;
            if (newHead1 != null) {
                newHead1 = newHead1.next;
            }
            if (newHead2 != null) {
                newHead2 = newHead2.next;
            }
        }
        return (resultList.next);
    }

    public static void main(String[] args) {
        int[] nums1 = { 9, 9, 9, 9, 9, 9, 9 };
        ListNode head1 = GetLinkedList(nums1);
        int[] nums2 = { 9, 9, 9, 9 };
        ListNode head2 = GetLinkedList(nums2);

        ListNode head = addTwoNumbers(head1, head2);
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

// Node class
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
