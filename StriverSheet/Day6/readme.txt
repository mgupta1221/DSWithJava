-- Notice how to iterate Linked list recursively and do operation from last to first Node
This pproach is used in "Flattening a linked list" question

 public static ListNode2 flatten(ListNode2 head) {
    if (head == null || head.next == null) {
        return head;
    }

    head.next = flatten(head.next);   <- see this line
    head = mergeTwoLL(head, head.next);
}