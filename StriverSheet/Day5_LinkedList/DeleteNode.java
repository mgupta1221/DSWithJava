package StriverSheet.Day5_LinkedList;

//LC 237. https://leetcode.com/problems/delete-node-in-a-linked-list/

//Problem: You are given the node to be deleted node. You will not be given access to the first node of head.

// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before node should be in the same order.
// All the values after node should be in the same order.

public class DeleteNode {
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {

        // Preparing the node which is to be deleted becuase Head of linked is not
        // provided
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = GetLinkedList(nums);
        ListNode nodeToBeDeleted = getNode(head, 2);

        deleteNode(nodeToBeDeleted);
    }

    // Helper Functions
    public static ListNode getNode(ListNode head, int val) {
        if (head == null)
            return null;
        while (head.val != val)
            head = head.next;

        return head;
    }

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
