package StriverSheet.Day6;
import StriverSheet.Day6.IntersectionOf2LL;

// LC: 142 https://leetcode.com/problems/linked-list-cycle-ii/

public class StartingPointOfLoop {
    public static ListNode detectCycle(ListNode head) {

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

        ListNode result = detectCycle(head);

        System.out.println(result.val);
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
