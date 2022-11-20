package StriverSheet.Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import GettingStartedBasics.Stack.MergeIntervals.Pair;

public class Test {
    public static int trap(int[] height) {


    }

    public static void main(String[] args) {
        int[] heights = { 3, 1, 2, 4, 0, 1, 3, 2 };

        int result = trap(heights);
        System.out.println((result));
    }

    public static int getLengthOfLinkedList(ListNode2 head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    // Helper Functions
    public static ListNode2 getNode(ListNode2 head, int val) {
        if (head == null)
            return null;
        while (head.val != val)
            head = head.next;

        return head;
    }

    public static ListNode2 GetLinkedList(int[] nums) {
        ListNode2 root = new ListNode2(nums[0]);

        ListNode2 item = root;
        for (int i = 1; i < nums.length; i++) {
            item.next = new ListNode2(nums[i]);
            item = item.next;
        }
        return root;
    }

    public static ListNode2 GetBottomLinkedList(int[] nums) {
        ListNode2 root = new ListNode2(nums[0]);

        ListNode2 item = root;
        for (int i = 1; i < nums.length; i++) {
            item.bottom = new ListNode2(nums[i]);
            item = item.bottom;
        }
        return root;
    }

    public static void PrintLinkedList(ListNode2 head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printLL(ListNode2 root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.bottom;
        }
    }
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2 bottom;

    public ListNode2(int val) {
        this.val = val;
        this.next = null;
        this.bottom = null;
    }

}
