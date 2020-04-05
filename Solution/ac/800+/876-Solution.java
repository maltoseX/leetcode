
/**
 * @author tostw
 * No.876 链表的中间结点
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
            if (quick.next != null) {
                quick = quick.next;
            } else {
                return slow;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        System.out.println(new Solution().middleNode(node1).val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

