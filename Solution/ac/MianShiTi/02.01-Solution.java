import java.util.*;

/**
 * @author tostw
 * 面试题 02.01. 移除重复节点
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        boolean[] visited = new boolean[20001];
        ListNode first = new ListNode(-1);
        ListNode p = first;
        while (head != null) {
            if (!visited[head.val]) {
                p.next = head;
                p = head;
                visited[head.val] = true;
            }
            head = head.next;
        }
        p.next = null;
        return first.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = new Solution().removeDuplicateNodes(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}