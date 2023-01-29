package StriverSheet.Day6;
import StriverSheet.Day6.IntersectionOf2LL;

// LC: 142 https://leetcode.com/problems/linked-list-cycle-ii/
// Approach:
// Step 1: Get meeting point of Slow and Fast pointer
// Step 2: Reset fast pointer to Start of the LL
// Step 3: Move slow and fast Pointer at same speed, where they meet is the Strating point

// Explanation why this approach works: https://www.youtube.com/watch?v=-YiQZi3mLq0
// Image: StartingPointOfLoop-Explanation.png

public class StartingPointOfLoop {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
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
