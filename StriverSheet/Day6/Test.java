package StriverSheet.Day6;

import java.util.*;

import StriverSheet.Day4.ThreeSum_3Sum;

public class Test {

   
    public static void main(String[] args) {
       
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
