package StriverSheet.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test1 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {

        }

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 5 };
        ListNode fourNode = new ListNode(4);
        ListNode head1 = GetLinkedList(nums1, fourNode);

        PrintLinkedList(head1);
        ListNode head = deleteNode(head1, fourNode);
        // PrintLinkedList(head);
        System.out.println(head.val);
    }

    public static ListNode GetLinkedList(int[] nums, ListNode fourNode) {
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;

        for (int i = 1; i < nums.length; i++) {
            if (i == 3) {
                temp.next = fourNode;
                temp = temp.next;
            } else {
                temp.next = new ListNode(nums[i]);
                temp = temp.next;
            }
        }
        temp.next = new ListNode(5);

        return head;
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
