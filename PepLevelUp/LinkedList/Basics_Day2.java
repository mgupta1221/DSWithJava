package PepLevelUp.LinkedList;

import java.util.ArrayList;

public class Basics_Day2 {

    // LC 19
    private static Node RemoveNthNodeFromEnd(Node head, int n) {

        if (head == null) {
            return head;
        }
        Node dummyHead = new Node(-1); // Creating a head node
        dummyHead.next = head;

        Node slow = dummyHead;
        Node fast = dummyHead;

        // first of all - move 'fast' node n times to have the required gap between fast
        // and slow
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next; // Notice we are skipping "-1" dummyNode added on the head in the begining
    }

    // LC 2
    private static Node addTwoNumbers(Node l1, Node l2) {

        // Base conditon
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        // Reversing both input linked list
        Node newHead1 = Reverse(l1);
        Node newHead2 = Reverse(l2);
        Node resultList = new Node(-1);
        Node itr = resultList;
        int carry = 0;
        while (newHead1 != null || newHead2 != null || carry != 0) {
            int sum = carry + (newHead1 != null ? newHead1.val : 0) + (newHead2 != null ? newHead2.val : 0);
            int digitSum = sum % 10;
            carry = sum / 10;
            Node newNode = new Node(digitSum);
            itr.next = newNode;
            itr = itr.next;
            if (newHead1 != null) {
                newHead1 = newHead1.next;
            }
            if (newHead2 != null) {
                newHead2 = newHead2.next;
            }
        }
        // returning the reversed
        return Reverse(resultList.next);
    }

    // Reverse helper
    private static Node Reverse(Node n) {
        Node current = n;
        Node previous = null;

        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    // LC 83: remove duplicates from Sorted list
    private static Node removeDuplicates(Node head) {
        // Base condition
        if (head == null)
            return head;

        Node itr = head;
        while (itr.next != null) {
            if (itr.val == itr.next.val) {
                itr.next = itr.next.next;
            } else {
                itr = itr.next;
            }
        }
        return head;
    }

    // LC 328
    private static Node OddEvenLinkedList(Node head) {
        // If there are 2 or less nodes , no action required
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node oddHead = head;
        Node evenHead = head.next;
        Node oddItr = head;
        Node evenItr = head.next;

        // Using 2 iterator - OddItr and EvenItr
        while (evenItr != null && evenItr.next != null) {
            oddItr.next = oddItr.next.next;// Skipping and joining alternate nodes
            evenItr.next = evenItr.next.next;
            oddItr = oddItr.next; // After 1 is pointed to 3 at first line above, now pointing oddItr to 3
            evenItr = evenItr.next;

        }
        oddItr.next = evenHead; // joining odd end to even head
        return oddHead;
    }

    // LC 148: Sort list
    // Note : we are taking head and tail both as arguements because we have find
    // middle node between 2 points multiple times
    // Solution Part 1 : https://www.youtube.com/watch?v=ClLO6kFF6gs
    // Solution Part 2 : https://www.youtube.com/watch?v=6vFEuO1pfJA
    private static Node SortList(Node head, Node tail) {
        // Base condn: if keep splitting till 1 node is left and return it as a new list
        if (head == tail) {
            Node newNode = new Node(head.val);
            return newNode;

        }

        Node mid = findMid(head, tail);
        Node head1 = SortList(head, mid);
        Node head2 = SortList(mid.next, tail);

        // merging the 2 sorted lists.. This is also LC 21
        return mergeLists(head1, head2);

    }

    // LC 21- merged Sorted Linked list
    // THis same function is also used to solve "Sort a linked list" - LC 148 above
    private static Node mergeLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node mergedList = new Node(-1);
        Node resultHead = mergedList;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                mergedList.next = head1;
                head1 = head1.next;
            } else {
                mergedList.next = head2;
                head2 = head2.next;
            }
            mergedList = mergedList.next;
        }
        if (head1 != null) {
            mergedList.next = head1;
        } else {
            mergedList.next = head2;
        }
        return resultHead.next;
    }

    // Helper to find mid node
    // Note here we are using tail as well since we have to split linekd list
    // everytime and than find the mid between 2 points
    private static Node findMid(Node head, Node tail) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    // LC 23 - Merge K sorted lists
    private static Node Merge_K_Sortedlists(Node[] lists) {
        Node first = lists[0];

        for (int i = 1; i < lists.length; i++) {
            first = mergeLists(first, lists[i]);
        }
        return first;
    }

    // Find length of linked list
    private static int findLengthAndPrintToo(Node root) {
        if (root == null)
            return 0;

        int len = 0;
        while (root != null) {
            len++;
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        return len;

    }

    // Helper function to create a linked list
    private static Node LinkedListCreator(int[] values) {
        // Node is created in separate file "Node.java"
        Node root = new Node(values[0]);
        Node node = root;
        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            node.next = newNode;
            node = newNode;
        }
        return root;
    }

    public static void main(String[] args) {

        // Rmeove nth node from end
        // int[] vals1 = new int[] { 1, 2, 3, 4, 5 };
        // Node head = LinkedListCreator(vals1);
        // head = RemoveNthNodeFromEnd(head, 2);
        // findLengthAndPrintToo(head);

        // LC 2
        // Add two numbers
        // int[] vals1 = new int[] { 2, 4, 9 };
        // Node list1 = LinkedListCreator(vals1);
        // vals1 = new int[] { 5, 6, 4, 9 };
        // Node list2 = LinkedListCreator(vals1);
        // Node mergedNode = addTwoNumbers(list1, list2);
        // findLengthAndPrintToo(mergedNode);

        // LC 83
        // Remove duplicates from sorted linked list
        // int[] vals1 = new int[] { 1, 1, 2, 3, 3 };
        // Node list1 = LinkedListCreator(vals1);
        // Node mergedNode = removeDuplicates(list1);
        // findLengthAndPrintToo(mergedNode);

        // // LC 328 - Segregating Odd Even Linked list
        // int[] vals1 = new int[] { 1, 2, 3, 4, 5 };
        // Node list1 = LinkedListCreator(vals1);
        // Node node = OddEvenLinkedList(list1);
        // findLengthAndPrintToo(node);

        // // LC 148 - Sort a linked list
        // int[] vals1 = new int[] { 3, 2, 4, 5, 1 };
        // Node head = LinkedListCreator(vals1);
        // // Getting end Node
        // Node itr = head;
        // while (itr.next != null) {
        // itr = itr.next;
        // }
        // Node node = SortList(head, itr);
        // findLengthAndPrintToo(node);

        // LC 23 - Sort k linked lists
        int[] vals = new int[] { 11, 22, 33, 44, 55 };
        Node head1 = LinkedListCreator(vals);

        vals = new int[] { 1, 2, 3, 4, 5 };
        Node head2 = LinkedListCreator(vals);

        vals = new int[] { 31, 32, 33, 34, 35 };
        Node head3 = LinkedListCreator(vals);

        // Note how we create array of nodes
        Node[] linkedLists = new Node[] { head1, head2, head3 };
        Node node = Merge_K_Sortedlists(linkedLists);// this will use "merge 2 lists" as helper method
        findLengthAndPrintToo(node);
    }
}
