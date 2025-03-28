package StriverSheet.Day6;

// LC: 160 https://leetcode.com/problems/intersection-of-two-linked-lists/

// Approach 1:
// Find difference(diff) in length of two LLs. Move the longer one by 'diff'. 
// Iterate by 1 node each time in a loop and keep checking until common node is found.

// Approach 2 (Optimized):
// Finding cycle approach - Iterate theough each LL in parrallel and when one LL ends,
// attach its end to the head of the other LL and keep iterating till the common node is found.

// Steps for Approach 2: 
// 1. Initialize two pointers ptr1 and ptr2  at head1 and  head2.
// 2. Traverse through the lists, one node at a time.
// 3. When ptr1 reaches the end of a list, then redirect it to head2.
// 4. similarly, when ptr2 reaches the end of a list, redirect it to the head1.
// 5. Once both of them go through reassigning, they will be equidistant from 
//    the collision point
// 6. If at any node ptr1 meets ptr2, then it is the intersection node.
// 7. After the second iteration if there is no intersection node it returns NULL.

// Time complexity : O( m + n ) 
// Auxiliary Space:  O(1)


// Approach 3: (Make a circle in the first list)  - Not coded below

// 1. Traverse the first linked list(count the elements) and make a circular linked list. (Remember the last node so
//    that we can break the circle later on). 
// 2. Now view the problem as finding the loop in the second linked list. So the problem is solved. 

public class IntersectionOf2LL {
    public static ListNode getIntersectionNode_approach2(ListNode head1, ListNode head2) {

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != temp2) {
            if (temp1 == null)
                temp1 = head2;
            if (temp2 == null)
                temp2 = head1;

            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        return temp1;

    }

    public static ListNode getIntersectionNode_approach1(ListNode head1, ListNode head2) {
        // Finding Diff in lengths of LL
        int diff = getLengthDiff(head1, head2);

        // Moving pointer of longer linked list by 'diff in length'
        if (diff > 0) {
            // Second LL is longer
            while (diff != 0) {
                head2 = head2.next;
                diff--;
            }
        } else {
            // First LL is longer
            while (diff != 0) {
                head1 = head1.next;
                diff++;
            }
        }

        // Now Moving both LL by 1 node each till common node is found
        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;

    }

    public static int getLengthDiff(ListNode head1, ListNode head2) {
        int len1 = 0;
        int len2 = 0;
        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }
        return len2 - len1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 8, 4, 5 };
        ListNode head1 = GetLinkedList(nums1);// LL 1 created

        // LL 2: { 5, 6, 1, 8, 4, 5 };
        ListNode tempHead = head1;
        tempHead = tempHead.next;
        ListNode head2 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        head2.next = node2;
        node2.next = tempHead;// LL2 created

        // ListNode intersectionNode = getIntersectionNode_approach1(head1, head2);
        ListNode intersectionNode = getIntersectionNode_approach2(head1, head2);
        System.out.println(intersectionNode.val);
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
