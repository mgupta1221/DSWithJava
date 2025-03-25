package Blind75;

public class RemoveNthNodeFromEnd19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        ListNode previous = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        // This condition is important to handle this input:
        // Input : List= [1], n = 1,
        // Output: []
        if (fast == null) {
            return head.next; // Remove the head
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
        int[] list = { 1 };
        ListNode head = ListNode.createLinkedList(list);
        ListNode.printList(head);
        ListNode result = removeNthFromEnd(head, 1);
        ListNode.printList(result);
    }
}
