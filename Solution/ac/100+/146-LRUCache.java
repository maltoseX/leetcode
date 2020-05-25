import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    Map<Integer, DlinkedNode> map;
    DlinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlinkedNode node = map.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DlinkedNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */