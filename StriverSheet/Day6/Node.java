package StriverSheet.Day6;

public class Node {
    public int val;
    public Node next;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    // Helper Functions
    public static Node GetLinkedList(int[] nums) {
        Node head = new Node(nums[0]);

        Node tempHead = head;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            tempHead.next = node;
            tempHead = node;
        }
        return head;
    }

    public static void PrintLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}
