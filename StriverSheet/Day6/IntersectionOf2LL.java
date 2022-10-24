package StriverSheet.Day6;

// LC: 160 https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionOf2LL {
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        // TO DO
        return null;

    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 8, 4, 5 };
        ListNode head1 = GetLinkedList(nums1);
        int[] nums2 = { 5, 6, 1, 8, 4, 5 };
        ListNode head2 = GetLinkedList(nums2);

        ListNode intersectionNode = getIntersectionNode(head1, head2);
        System.out.println(intersectionNode);
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
