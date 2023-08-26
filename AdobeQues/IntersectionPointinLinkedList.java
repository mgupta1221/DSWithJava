package AdobeQues;

import StriverSheet.Day6.Node;

public class IntersectionPointinLinkedList {

    static int intersectPoint(Node head1, Node head2) {
        Node node = head1;
        int result = -1;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head2;

        Node slow = head1;
        Node fast = head1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head1;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                result = slow.val;
            }
        }
        slow = head1;
        while (slow.next != head2) {
            slow = slow.next;
        }
        slow.next = null;

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 8, 4, 5 };
        Node head1 = Node.GetLinkedList(nums1);// LL 1 created

        // LL 2: { 5, 6, 1, 8, 4, 5 };
        Node tempHead = head1;
        tempHead = tempHead.next;
        Node head2 = new Node(5);
        Node node2 = new Node(6);
        head2.next = node2;
        node2.next = tempHead;// LL2 created

        int result = intersectPoint(head1, head2);
        System.out.println(result);
    }
}
