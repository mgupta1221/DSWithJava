package Blind75;

public class ReOrderList143 {
    public static void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;
        ListNode middle = findMiddleNode(head);
        ListNode head2 = reverseList(middle.next);

        middle.next = null; // disconnecting after reversing
        mergeLists(head, head2);

    }

    public static void mergeLists(ListNode first, ListNode second) {
        ListNode tempFirst;
        ListNode tempSecond;
        while (second != null) {
            tempFirst = first.next;
            tempSecond = second.next;

            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.createLinkedList(list);
        ListNode.printList(head);
        reorderList(head);
        ListNode.printList(head);
    }

}
