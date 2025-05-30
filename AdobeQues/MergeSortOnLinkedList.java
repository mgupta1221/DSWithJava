package AdobeQues;

import StriverSheet.Day6.Node;

// Problem :https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1

// The task is to Sort the given linked list using Merge Sort.

public class MergeSortOnLinkedList {

    static Node mergeSort(Node head) {

        if (head == null || head.next == null)
            return head; // make sure to return 'head' only and not 'null' here as answer will not come
        // because in case head.next is null so there is only single node which we can
        // return and in case head is null that mean list is empty so null cna be
        // returned

        // Finding mid node
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // This is important and used to break the Linked list at mid node
        // Linked list split here in next 2 statements
        Node mid = slow;
        Node nextOfMiddle = mid.next;
        mid.next = null;

        // Merge Sort logic begins after finding mid
        // Notice we are capturing the result here to pass to merge() func. In normal
        // meregSort we dont capture the result since we have 'mid' available in the
        // case.
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle); // passing second half

        return merge(left, right);
    }

    static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node head;
        Node tail;

        if (left.val <= right.val) {
            head = left;
            tail = left;
            left = left.next;
        } else {
            head = right;
            tail = right;
            right = right.next;
        }

        while (right != null && left != null) {
            if (left.val <= right.val) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }
        if (left != null) {
            tail.next = left;
            tail = left;
        }
        if (right != null) {
            tail.next = right;
            tail = right;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] vals1 = new int[] { 3, 2, 4, 5, 1 };
        Node head = Node.GetLinkedList(vals1);
        head = mergeSort(head);

        Node.PrintLinkedList(head);
    }

}
