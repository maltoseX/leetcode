
/**
 * Solution
 *
 * No.160 相交链表
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA0 = new ListNode(4);
        ListNode headA1 = new ListNode(1);
        ListNode headA2 = new ListNode(8);
        ListNode headA3 = new ListNode(4);
        ListNode headA4 = new ListNode(5);
        ListNode headB0 = new ListNode(5);
        ListNode headB1 = new ListNode(0);
        ListNode headB2 = new ListNode(1);
        ListNode headB3 = new ListNode(8);
        ListNode headB4 = new ListNode(4);
        ListNode headB5 = new ListNode(5);
        headA0.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;

        headB0.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        headB4.next = headB5;
        System.out.println(solution.getIntersectionNode(headA0, headB0).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode intersectNode = null;
        int aListLength = getListLength(headA);
        int bListLength = getListLength(headB);
        int diff = aListLength - bListLength;

        ListNode pointerA = headA;
        ListNode pointerB = headB;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                pointerA = pointerA.next;
            }
        } else if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                pointerB = pointerB.next;
            }
        }

        while (pointerA.next != null) {
            if (pointerA.val == pointerB.val && intersectNode == null) {
                intersectNode = pointerA;
            } else if (pointerA.val != pointerB.val && intersectNode != null) {
                intersectNode = null;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        return intersectNode;
    }

    public int getListLength(ListNode node) {
        int length = 0;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}