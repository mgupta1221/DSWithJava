package Blind75;

public class MergeTwoSortedLL21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode rootNode = dummyHead;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyHead.next = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                l2 = l2.next;
            }
            dummyHead = dummyHead.next;
        }
        dummyHead.next = l1 == null ? l2 : l1;
        return rootNode.next;
    }

    public static void main(String[] args) {

        int[] list1 = { 1, 2, 4 };
        int[] list2 = { 1, 3, 4 };
        ListNode head1 = ListNode.createLinkedList(list1);
        ListNode head2 = ListNode.createLinkedList(list2);
        ListNode mergedList = mergeTwoLists(head1, head2);

        ListNode.printList(mergedList);
    }
}
