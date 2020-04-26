/**
 * @author tostw
 * No.203 移除链表元素
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(Integer.MAX_VALUE);
        first.next = head;
        ListNode node = first;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return first.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}