package StriverSheet.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test1 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = getLengthOfLinkedList(head);
        ListNode result = reverseKGroup_recur(head, k, len);
        return result;

    }

    public static ListNode reverseKGroup_recur(ListNode head, int k, int len) {
        if (len < k) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        if (len > k) {
            for (int i = 1; i <= k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
        }
        if (next != null)
            head.next = reverseKGroup_recur(next, k, len - k);
        return previous;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = GetLinkedList(nums1);
        ListNode head2 = reverseKGroup(head1, 2);
        PrintLinkedList(head2);
    }

    public static int getLengthOfLinkedList(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
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

    public static void PrintLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

}

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
