/**
 * @author tostw
 * No.25 K个一组翻转链表
 */

class Solution {
    int k;
    // 已翻转的子链表头
    ListNode newHead;
    // 已翻转的子链表尾
    ListNode newEnd;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return head;
        }
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        pre.next = head;
        this.k = k;
        reverse(pre, head, 1);
        return pre.next;
    }

    private boolean reverse(ListNode pre, ListNode node, int times) {
        if (node == null) {
            return false;
        }

        if (times == k) {
            pre.next = node.next;
            node.next = pre;
            newHead = node;
            newEnd = pre;
            return true;
        }
        if (!reverse(node, node.next, times + 1)) {
            return false;
        } else {
            if (times == 1) {
                pre.next = newHead;
                node.next = newEnd.next;
                reverse(node, newEnd.next, 1);
            } else {
                pre.next = newEnd.next;
                newEnd.next = pre;
                newEnd = pre;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = new Solution().reverseKGroup(node1, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

