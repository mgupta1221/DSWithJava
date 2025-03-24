package PepLevelUp.LinkedList;

public class Basics_Day1 {
    // LC 876 - Middle of the linked list
    private static Node findMiddleNode(Node root) {
        if (root == null || root.next == null)
            return null;

        Node slowPointer = root;
        Node fastPointer = root;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    // LC 206 - Reverse the list and return it
    private static Node Reverse(Node root) {
        if (root == null)
            return null;

        Node currentNode = root;
        Node previousNode = null;

        while (currentNode != null) {
            Node temp = currentNode.next; // preserve
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;

        }
        return previousNode;

    }

    // LC 234 - is Pallendrome
    // Idea is to reach the middle node and than reverse the second part and than
    // compare
    private static boolean isPallendrome(Node root) {
        if (root == null)
            return false;

        Node middleNode = findMiddleNode(root);// reach the middle node
        Node newhead = Reverse(middleNode.next); // then reverse the second part
        findLengthAndPrintToo(newhead);
        // Node newhead = Reverse(middleNode.next);

        while (root != null && newhead != null) { // check if both parts are same
            if (root.val != newhead.val) {
                return false;
            }
            root = root.next;
            newhead = newhead.next;
        }
        return true;
    }

    // LC 143 - Reorder list
    // Idea is to reeach the mid and reverse the second part
    // Now you have 2 lists -i.e. first part as it is and second part in reveresed
    // form
    // Take one element from each and put them one after another till the end.
    private static Node ReorderList(Node root) {
        if (root == null || root.next == null)
            return null;

        Node middleNode = findMiddleNode(root);
        var tempNext = middleNode.next; // temporarily storing to get the second part reveresed using it
        middleNode.next = null; // this step is important to cut the list , otherwise it will bceome infinite
        Node newHeadWithReversed = Reverse(tempNext);
        Node c1 = root;
        Node c2 = newHeadWithReversed;
        while (c2 != null) {
            Node temp1 = c1.next;
            Node temp2 = c2.next;
            c1.next = c2;
            c2.next = temp1;
            c1 = temp1;
            c2 = temp2;
        }

        return root;
    }

    // LC 21 Merge 2 Sorted List
    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        Node dummyHead = new Node(-1);
        Node rootNode = dummyHead;
        Node l1 = list1;
        Node l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyHead.next = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                l2 = l2.next;
            }
            dummyHead = dummyHead.next;
        }
        dummyHead.next = l1 == null ? l2 : l1;
        return rootNode.next;
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
        int[] vals = new int[] { 3, 5, 11, 7, 1, 16 };
        Node root = LinkedListCreator(vals);

        // Node middleNode = findMiddleNode(root);
        // System.out.println(middleNode.val);

        // int len = findLengthAndPrintToo(root);
        // System.out.println(len);

        // Node rootNode = Reverse(root);
        // findLengthAndPrintToo(rootNode);

        // Boolean result = isPallendrome(root);
        // System.out.println(result);

        // Node rootNode = ReorderList(root);
        // findLengthAndPrintToo(rootNode);
        // 3 ,16,5,1,11,7

        int[] vals1 = new int[] { 2 };
        Node list1 = LinkedListCreator(vals1);
        vals1 = new int[] { 1 };
        Node list2 = LinkedListCreator(vals1);
        Node mergedNode = mergeTwoLists(list1, list2);
        findLengthAndPrintToo(mergedNode);

    }
}
