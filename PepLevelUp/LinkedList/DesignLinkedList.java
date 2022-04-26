package PepLevelUp.LinkedList;

//LC:  707
public class DesignLinkedList {
    
    Node head = null;
    private int size = 0;

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public DesignLinkedList() {
        head = null;
    }

    // Helper
    public boolean isEmpty() {
        return size == 0;
    }

    // Helper
    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node itr = this.head;
        int count = 0;
        while (count != index) {
            itr = itr.next;
            count++;
        }
        return itr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    public void addAtTail(int val) {

        if (isEmpty()) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node itr = this.head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node itr = this.head;
        int count = 0;
        while (count != index - 1) {
            itr = itr.next;
            count++;
        }
        newNode.next = itr.next;
        itr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node itr = this.head;
        int count = 0;
        while (count != index - 1) {
            itr = itr.next;
            count++;
        }
        if (itr.next.next != null) {
            itr.next = itr.next.next;
        } else {
            itr.next = null;
        }
        size--;
    }
}
