package AdobeQues;

import StriverSheet.Day6.Node;

public class test {

    public static void removeLoop(Node head) {

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
