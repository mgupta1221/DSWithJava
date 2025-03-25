package Blind75;

public class ListNode {
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

    public static ListNode createLinkedList(int[] arr) {
        // Check if the array is empty
        if (arr == null || arr.length == 0) {
            return null; // Return null for an empty list
        }

        // Create the head of the linked list
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // Iterate through the array and create nodes
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]); // Create new node and link it
            current = current.next; // Move to the next node
        }

        return head; // Return the head of the linked list
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}