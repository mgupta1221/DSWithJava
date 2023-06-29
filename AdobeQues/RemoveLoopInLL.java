package AdobeQues;

import StriverSheet.Day6.Node;

public class RemoveLoopInLL {

    // Problem:
    // https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
    // We have to remove the loop from the LL if exists by disconnected the node
    // from one point which forms the loop

    // E.g. 1>2>3>4>2 <- Here 4 is reconnected to 2 ...
    // Answer of this question should return 1>2>3>4

    // Solution:
    // 1. First we detect if loop exists using slow and fast pointer logic
    // 2. Second we go to the starting point of the loop i.e. 2
    // 3. We move 'fast' pointer one step at a time till fast's next is not pointing
    // i.e. till 'fast' reaches 4
    // to slow node
    // 4. We set fast.next =null

    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {// cycle deteted
                slow = head;
                // Now finding starting point of the loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // move fast till fast's next does not reach slow
                while (slow != fast.next) {
                    fast = fast.next;
                }
                // set fast's next to null to remove the loop
                fast.next = null;
            }
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head; // cycle created here

        removeLoop(head);

        Node.PrintLinkedList(head);
    }

}
