import java.util.Stack;

/**
 * @author tostw
 * No.445 两数相加II
 */
public class Solution {

    // 方法一：使用数组
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] numArr1 = convertListToArray(l1);
        int len1 = numArr1.length;
        int[] numArr2 = convertListToArray(l2);
        int len2 = numArr2.length;

        int len = Math.max(len1, len2) + 1;
        numArr1 = fillZero(numArr1, len);
        numArr2 = fillZero(numArr2, len);
        int[] sum = new int[len];

        for (int i = len - 1, carry = 0, temp; i >= 0; i--) {
            temp = numArr1[i] + numArr2[i] + carry;
            carry = temp / 10;
            sum[i] = temp % 10;
        }

        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ListNode p = ans;
        for (int i = sum[0] == 0 ? 1 : 0; i < len; i++) {
            p.next = new ListNode(sum[i]);
            p = p.next;
        }

        return ans.next;
    }

    private int[] fillZero(int[] arr, int length) {
        int[] newArr = new int[length];
        System.arraycopy(arr, 0, newArr, length - arr.length, arr.length);
        return newArr;
    }

    private int[] convertListToArray(ListNode node) {
        int length = 0;
        ListNode p = node;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = node.val;
            node = node.next;
        }
        return num;
    }

    // 方法二：使用Stack
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//
//        while (l1 != null) {
//            stack1.push(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            stack2.push(l2.val);
//            l2 = l2.next;
//        }
//
//        int carry = 0;
//        ListNode head = null;
//        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
//            int sum = carry;
//            sum += stack1.isEmpty() ? 0 : stack1.pop();
//            sum += stack2.isEmpty() ? 0 : stack2.pop();
//            ListNode node = new ListNode(sum % 10);
//            node.next = head;
//            head = node;
//            carry = sum / 10;
//        }
//        return head;
//    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}