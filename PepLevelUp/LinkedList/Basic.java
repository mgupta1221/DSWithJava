package PepLevelUp.LinkedList;

public class Basic {
    // LC 876 - Middle of the linked list

    private static Node LinkedListCreator(int[] values) {
        //Node is created in separate file "Node.java"
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
        int[] vals = new int[] { 3, 5, 11, 44 };
        Node root = LinkedListCreator(vals);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
