/**
 * @author tostw
 * No.24 两两交换链表中的节点
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newListHead = new ListNode(Integer.MAX_VALUE);
        newListHead.next = head;
        swapNextTwoNodes(newListHead);
        return newListHead.next;
    }

    private void swapNextTwoNodes(ListNode node) {
        ListNode prev = node.next;
        if (prev == null) {
            return;
        }
        ListNode post = prev.next;
        if (post == null) {
            return;
        }

        prev.next = post.next;
        post.next = prev;
        node.next = post;
        swapNextTwoNodes(prev);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}