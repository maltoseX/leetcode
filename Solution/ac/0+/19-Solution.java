import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * No.19 删除链表的倒数第N个节点
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int i;
        for (i = 0; node != null; ++i) {
            map.put(i, node);
            node = node.next;
        }
        if (n > i || (i == 1 && n == 1)) {
            return null;
        } else if (n == i) {
            head = head.next;
        } else if (n == 1) {
            map.get(i - 2).next = null;
        } else {
            map.get(i - n - 1).next = map.get(i - n + 1);
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        return head;
    }

}


//// 执行用时为0ms的范例，用双指针
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next == null)
//            return null;
//        ListNode p1=head, p2=head;
//        for(int i=0;i<n;i++){
//            p2 = p2.next;
//            if( i == n-2 && p2.next == null)
//                return head.next;
//        }
//        while(p2.next != null){
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        p1.next = p1.next.next;
//        return head;
//    }
//}


