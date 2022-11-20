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
        head.next = flatten(head.next); // this line is important how recursive call is assigned back to head.next
        head = mergeSortedLinkedLists(head, head.next); // and than merged result is sent back to head
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

        // Preparing data -- starts
        int[] nums = { 5, 10, 19, 28 };

        NodeF head = GetLinkedList(nums);

        // Getting Node 19 to assign bottom list to it

        NodeF itrNode1 = head;
        while (itrNode1.val != 19) {
            itrNode1 = itrNode1.next;
        }
        int[] nums1 = { 22, 50 };
        NodeF bottomHead1 = GetBottomLinkedList(nums1);

        // Getting Node 28 to assign bottom list to it

        NodeF itrNode2 = head;
        while (itrNode2.val != 28) {
            itrNode2 = itrNode2.next;
        }

        int[] nums2 = { 35, 40, 45 };
        NodeF bottomHead2 = GetBottomLinkedList(nums2);

        itrNode1.bottom = bottomHead1;
        itrNode2.bottom = bottomHead2;

        // Preparing data -- ends

        NodeF result = flatten(head);

        PrintLinkedList(result);

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

    public static NodeF GetBottomLinkedList(int[] nums) {
        NodeF head = new NodeF(nums[0]);

        NodeF tempHead = head;
        for (int i = 1; i < nums.length; i++) {
            NodeF node = new NodeF(nums[i]);
            tempHead.bottom = node;
            tempHead = node;
        }
        return head;
    }

    public static void PrintLinkedList(NodeF head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.bottom;
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
