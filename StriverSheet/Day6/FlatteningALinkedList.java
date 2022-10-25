package StriverSheet.Day6;

import StriverSheet.Day6.IntersectionOf2LL;

// Geeks for geeks 
// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

// Approach: https://www.youtube.com/watch?v=3TtlbiCMivo

// We used Recursion to reach the end of the Linked List (using Next) and assume each recursive call 
// will return the sorted Linkedlists
// and then merge the Sub-Linkedlists till we find the final sorted linked list.

// For Merging, we use the same logic as used for "Merging 2 sorted linked lists" and call 
// it in the recursive function with 2 set of consecutive 'bottom' linked lists.  (head, head.next)

public class FlatteningALinkedList {
    public static NodeF flatten(NodeF head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flatten(head.next);
        head = mergeSortedLinkedLists(head, head.next);
        return head;
    }

    public static NodeF mergeSortedLinkedLists(NodeF head1, NodeF head2) {
        NodeF resultingList = new NodeF(-1);
        NodeF tempResultPointer = resultingList;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tempResultPointer.bottom = head1;
                tempResultPointer = tempResultPointer.bottom;
                head1 = head1.bottom;
            } else {
                tempResultPointer.bottom = head2;
                tempResultPointer = tempResultPointer.bottom;
                head2 = head2.bottom;
            }
        }
        if (head1 != null) {
            tempResultPointer.bottom = head1;
        }
        if (head2 != null) {
            tempResultPointer.bottom = head2;
        }
        return resultingList.bottom;

    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 5, 5, 2, 1 };
        NodeF head = GetLinkedList(nums1);

        NodeF result = flatten(head);

        System.out.println(result.val);
    }

    // Helper Functions
    public static NodeF GetLinkedList(int[] nums) {
        NodeF head = new NodeF(nums[0]);

        NodeF tempHead = head;
        for (int i = 1; i < nums.length; i++) {
            NodeF node = new NodeF(nums[i]);
            tempHead.next = node;
            tempHead = node;
        }
        return head;
    }

    public static void PrintLinkedList(NodeF head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}

// Node class
class NodeF {
    int val;
    NodeF next;
    NodeF bottom;

    NodeF() {
    }

    NodeF(int val) {
        this.val = val;
    }

    NodeF(int val, NodeF next) {
        this.val = val;
        this.next = next;
        this.bottom = null;
    }
}
