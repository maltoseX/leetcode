import java.util.HashMap;
import java.util.Map;

/**
 * @author tostw
 * No.460 LFU缓存
 */
class LFUCache {

    /**
     * 存储缓存的内容，Node中除了value值外，还有key、freq、所在的DoublyLinkedList、
     * 所在doublyLinkedList中的postNode、所在doublyLinkedList中的preNode，具体定义在下方。
     */
    Map<Integer, Node> cache;

    /**
     * firstLinkedList.post 是频次最大的双向链表
     */
    DoublyLinkedList firstLinkedList;

    /**
     * lastLinkedList.pre 是频次最小的双向链表，满了之后删除 lastLinkedList.pre.tail.pre，
     * 这个Node即为频次最小且访问最早的Node
     */
    DoublyLinkedList lastLinkedList;

    int size;

    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        firstLinkedList = new DoublyLinkedList();
        lastLinkedList = new DoublyLinkedList();
        firstLinkedList.post = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 该key访问频次 + 1
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);

        // 若key存在，则更新value，访问频次 + 1
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else { //若key不存在

            // 如果缓存满了，删除lastLinkedList.pre这个链表（即表示最小频次的链表）中的ail.pre这个Node（即最小频次链表中最先访问的Node），
            // 如果该链表中的元素删空了，则删掉该链表。
            if (size == capacity) {
                cache.remove(lastLinkedList.pre.tail.pre.key);
                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
                size--;
                if (lastLinkedList.pre.head.post == lastLinkedList.pre.tail) {
                    removeDoublyLinkedList(lastLinkedList.pre);
                }
            }

            // cache中put新Key—Node对，并将新node加入表示freq为1的DoublyLinkedList中，若不存在freq为1的DoublyLinkedList则创建。
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if (lastLinkedList.pre.freq != 1) {
                DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList(1);
                addDoublyLinkedList(newDoublyLinkedList, lastLinkedList.pre);
                newDoublyLinkedList.addNode(newNode);
            } else {
                lastLinkedList.pre.addNode(newNode);
            }
            size++;
        }
    }

    /**
     * node 的访问频次 + 1
     */
    void freqInc(Node node) {

        // 将node从原freq对应的双向链表里移除，如果链表空了则删除链表。
        DoublyLinkedList linkedList = node.doublyLinkedList;
        DoublyLinkedList preLinkedList = linkedList.pre;
        linkedList.removeNode(node);
        if (linkedList.head.post == linkedList.tail) {
            removeDoublyLinkedList(linkedList);
        }

        // 将node加入新freq对应的双向链表，若该链表不存在，则先创建链表
        node.freq++;
        if (preLinkedList.freq != node.freq) {
            DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList(node.freq);
            addDoublyLinkedList(newDoublyLinkedList, preLinkedList);
            newDoublyLinkedList.addNode(node);
        } else {
            preLinkedList.addNode(node);
        }
    }

    /**
     * 增加代表某1频次的双向链表
     */
    void addDoublyLinkedList(DoublyLinkedList newDoublyLinkedList, DoublyLinkedList preLinkedList) {
        newDoublyLinkedList.post = preLinkedList.post;
        newDoublyLinkedList.post.pre = newDoublyLinkedList;
        newDoublyLinkedList.pre = preLinkedList;
        preLinkedList.post = newDoublyLinkedList;
    }

    /**
     * 删除代表某1频次的双向链表
     */
    void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        doublyLinkedList.pre.post = doublyLinkedList.post;
        doublyLinkedList.post.pre = doublyLinkedList.pre;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
    int key;
    int value;
    int freq = 1;

    /**
     * Node所在频次的双向链表的前继Node
     */
    Node pre;

    /**
     * Node所在频次的双向链表的后继Node
     */
    Node post;

    /**
     * Node所在频次的双向链表
     */
    DoublyLinkedList doublyLinkedList;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {

    /**
     * 该双向链表表示的频次
     */
    int freq;

    /**
     * 该双向链表的前继链表（pre.freq < this.freq）
     */
    DoublyLinkedList pre;

    /**
     * 该双向链表的后继链表（post.freq > this.freq）
     */
    DoublyLinkedList post;

    /**
     * 该双向链表的头节点，新节点从头部加入，表示最近访问
     */
    Node head;

    /**
     * 该双向链表的尾节点，删除节点从尾部删除，表示最久访问
     */
    Node tail;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }

    public DoublyLinkedList(int freq) {
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
        this.freq = freq;
    }

    void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    void addNode(Node node) {
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
        node.pre = head;
        node.doublyLinkedList = this;
    }
}