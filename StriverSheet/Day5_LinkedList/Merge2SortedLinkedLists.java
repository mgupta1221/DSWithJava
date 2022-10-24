package StriverSheet.Day5_LinkedList;

// LC: 21 https://leetcode.com/problems/merge-two-sorted-lists/

public class Merge2SortedLinkedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode rootNode = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummyHead.next = list1;
                list1 = list1.next;
            } else {
                dummyHead.next = list2;
                list2 = list2.next;
            }
            dummyHead = dummyHead.next;
        }

        if (list1 != null) {
            dummyHead.next = list1;
        }
        
        if (list2 != null) {
            dummyHead.next = list2;
        }

        return rootNode.next;

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 4 };
        ListNode head1 = GetLinkedList(nums1);
        int[] nums2 = { 1, 3, 4 };
        ListNode head2 = GetLinkedList(nums2);

        ListNode head = mergeTwoLists(head1, head2);
        PrintLinkedList(head);
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
