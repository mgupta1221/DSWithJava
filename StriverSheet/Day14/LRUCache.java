package StriverSheet.Day14;

import java.util.HashMap;

// Problem: https://leetcode.com/problems/lru-cache/description/

// Approach: We will create a HashMap<> to store <key, Node> pair. We will make a linked list with 'head'
// and 'tail' node and all elements will lie between them. Whenever an element is accessed, 
// we will remove it from its position from linked list and put it as next node to head(bring in front)

class LRU_Cache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map = new HashMap<>();

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        RemoveNode(node);
        addTohead(node);

        return node.value;

    }

    public void addTohead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    public void RemoveNode(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            RemoveNode(map.get(key));
        }

        if (map.size() == capacity) {
            RemoveNode(tail.prev);
        }
        Node node = new Node(key, value);
        addTohead(node);

    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int item = cache.get(1);
        System.out.println(item);
        cache.put(3, 3);
        item = cache.get(2);
        System.out.println(item);
        cache.put(4, 4);
        item = cache.get(1);
        System.out.println(item);
        item = cache.get(3);
        System.out.println(item);
        item = cache.get(4);
        System.out.println(item);

    }
}