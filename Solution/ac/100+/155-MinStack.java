import java.util.Stack;

public class MinStack {
    Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() { }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x,Math.min(head.min,x),head);
        }
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class Node {
    int val;
    int min;
    Node prev;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }

    public Node(int val, int min, Node prev) {
        this.val = val;
        this.min = min;
        this.prev = prev;
    }
}

