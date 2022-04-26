package PepLevelUp.LinkedList;

import java.util.HashMap;
import java.util.Map;

// LC 146
// Solution:
// https://github.com/luckykumardev/leetcode-solution/blob/master/LRU%20Cache.java
// Explanation:
// https://www.youtube.com/watch?v=rRLXvqTyQ8k

// This solution does not have main function 
// We use Doubly linked list becuase we have insert and remove items get in O(1) time

// In 'get', we search the node via hashmap and bring it to the 'head of doubly link list'

// In 'put', we check if the key is present in hashmap than delete and also check if 
// the list is full than firsst remove tail..After these two , insert the node to head

// We also use Hashmap becuase we want to search the nodes in O(1) time

// The main trick is to have initialize head and tail in the start itself
// and We do all insert and delete operations between head and tail node, for this not line 
// 'Node tail = this.tail.prev;' we remove node previous to tail when list is full instead
//  of previous

public class LRU_Cache {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> hashmap = new HashMap<>();

    // Helper:we create this ourselves
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int data) {
            this.key = key;
            this.val = data;
        }
    }

    public LRU_Cache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // point head to tail and tail to head below
        head.next = tail;
        tail.prev = this.head;
        this.capacity = capacity;
    }

    // Helper
    public void RemoveNode(Node node) {
        // always maintain hashmap on removal or addition of nodes
        hashmap.remove(node.key);
        Node previous = node.prev;
        previous.next = node.next;
        Node next = node.next;
        next.prev = previous;
    }

    // Helper
    public void AddNodetoHead(Node node) {
        hashmap.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }

    // Real method to get given signatures in question
    public int get(int key) {
        Node node = hashmap.get(key);
        if (node == null) {
            return -1;
        } else {
            RemoveNode(node);
            AddNodetoHead(node);
            return node.val;
        }

    }

    // Real method to insert given signatures in question
    public void put(int key, int value) {
        // if key is already present than we will remove the existing Node
        // and insert the new one to the head
        if (hashmap.containsKey(key)) {
            Node node = hashmap.get(key);
            RemoveNode(node);
        }

        if (hashmap.size() == capacity) {
            // Important Notice tail is just for management..All nodes are managed between
            // head and
            // tail
            Node tail = this.tail.prev;
            RemoveNode(tail);
        }
        Node newNode = new Node(key, value);
        AddNodetoHead(newNode);
    }
}
