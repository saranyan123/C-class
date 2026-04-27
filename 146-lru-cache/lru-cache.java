import java.util.*;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { this.key = k; this.value = v; }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update the value
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                // Evict the LRU node (the one before tail)
                Node lru = tail.prev;
                map.remove(lru.key);
                removeNode(lru);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
