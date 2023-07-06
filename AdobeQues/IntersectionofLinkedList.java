package AdobeQues;

import StriverSheet.Day6.Node;

// https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
// https://leetcode.com/problems/intersection-of-two-linked-lists/
// Solved earlier

// Approach 1 (Not solved below):
// Find difference(diff) in length of two LLs. Move the longer one by 'diff'. 
// Iterate by 1 node each time in a loop and keep checking until common node is found.

// Approach 2:(Solved below)
// 1. Traverse the first linked list(count the elements) and make a circular linked list. (Remember the last node so
//    that we can break the circle later on). 
// 2. Now view the problem as finding the loop in the second linked list. So the problem is solved. 

// Note : Notice how '-1' is returned if no cycle is found.

public class IntersectionofLinkedList {

    public static int intersectPoint(Node head1, Node head2) {

        Node l1 = head1;

        // Reaching the end of any one list
        while (l1.next != null) {
            l1 = l1.next;
        }
        // after reaching end, attach list's tail to head of another list
        // a loop
        l1.next = head2;

        // Now detect cycle.
        // Notice we are initiliazing the slow and fast from head of the same LL
        Node slow = head1;
        Node fast = head1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle detected
                break;
            }
        }

        // Now finding starting point of loop
        slow = head1;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (slow == null || fast == null) {// If no cycle found, return -1
                return -1;
            }
        }

        return slow.val;

    }

    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 8, 4, 5 };
        Node head1 = Node.GetLinkedList(nums1);// LL 1 created

        // LL 2: { 5, 6, 1, 8, 4, 5 };
        Node tempHead = head1;
        tempHead = tempHead.next;
        Node head2 = new Node(5);
        Node node2 = new Node(6);
        head2.next = node2;
        node2.next = tempHead;// LL2 created

        int result = intersectPoint(head1, head2);

        System.out.println(result);
    }
}
