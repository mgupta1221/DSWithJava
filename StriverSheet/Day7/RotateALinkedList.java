package StriverSheet.Day7;

public class RotateALinkedList {

    // LC 61 - https://leetcode.com/problems/rotate-list/description/

    public static ListNode rotateRight(ListNode head, int k) {

        if (k <= 0 || head == null) {
            return head;
        }

        // Get length and reach to the end of node
        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }

        // This is done to handle if number of rotations required are more than the
        // length of LL
        // E.g. [0,1,2] and k=4
        k = k % len;

        // If number of rotations required is same as length than norotation required,
        // return head
        if (k == 0)
            return head;

        // Connect last node with the head of the node
        temp.next = head;

        // Reach kth Node
        ListNode current = head;
        for (int i = 1; i < len - k; i++) {
            current = current.next;
        }

        // Make (K+1)th node as head
        head = current.next;

        // Make Kth node's next as null so that it becomes the last node of updated LL
        current.next = null;

        return head;
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
        ListNode head = GetLinkedList(nums1);

        ListNode result = rotateRight(head, 2);
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
