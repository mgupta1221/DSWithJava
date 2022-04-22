package PepLevelUp.LinkedList;

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
        // returning the reversed list
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

        // Add two numbers
        int[] vals1 = new int[] { 2, 4, 9 };
        Node list1 = LinkedListCreator(vals1);
        vals1 = new int[] { 5, 6, 4, 9 };
        Node list2 = LinkedListCreator(vals1);
        Node mergedNode = addTwoNumbers(list1, list2);
        findLengthAndPrintToo(mergedNode);

    }
}
