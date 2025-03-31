package Blind75;

public class MergekSortedLists23 {

    // Approach: (For this problem, first solve "Merge 2 sorted list problem" LC:21
    // )
    // 1. Merge Two Lists at a Time:
    // 2. Instead of merging all lists at once, split the list into 2
    // halves(something like Merge Sort)
    // 3. Recursively merge two halves. Use a helper function mergeKListsHelper to
    // divide the problem into smaller parts.

    public static ListNode MergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return MergeKListshelper(0, lists.length - 1, lists);
    }

    public static ListNode MergeKListshelper(int low, int high, ListNode[] lists) {
        if (low == high) {
            return lists[low];
        }

        int mid = low + (high - low) / 2;
        ListNode l1 = MergeKListshelper(low, mid, lists);
        ListNode l2 = MergeKListshelper(mid + 1, high, lists);
        return Merge2Lists(l1, l2);
    }

    public static ListNode Merge2Lists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            if (val1 <= val2) {
                result.next = new ListNode(val1);
                list1 = list1.next;
                result = result.next;

            } else {
                result.next = new ListNode(val2);
                list2 = list2.next;
                result = result.next;
            }
        }

        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }

        return tempResult.next;
    }

    public static void main(String[] args) {

        int[] list1 = { 1, 2, 4 };
        int[] list2 = { 1, 3, 4 };
        int[] list3 = { 3, 4, 8 };
        ListNode head1 = ListNode.createLinkedList(list1);
        ListNode head2 = ListNode.createLinkedList(list2);
        ListNode head3 = ListNode.createLinkedList(list3);

        ListNode[] LLList = new ListNode[3];
        LLList[0] = head1;
        LLList[1] = head2;
        LLList[2] = head3;
        ListNode mergedList = MergeKLists(LLList);

        ListNode.printList(mergedList);
    }
}
