import java.util.Stack;

/**
 * @author tostw
 * No.227 基本计算器
 */
class Solution {
    public int calculate(String s) {
        int[] nums = new int[s.length()];
        int top = -1;
        char operator = '+';
        char[] arr = s.toCharArray();

        int temp = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            if (arr[i] == ' ') {
                continue;
            } else if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                operator = arr[i];
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                while (i < len && arr[i] >= '0' && arr[i] <= '9') {
                    temp = temp * 10 + arr[i] - '0';
                    i++;
                }
                i--;
                if (operator == '+') {
                    nums[++top] = temp;
                } else if (operator == '-') {
                    nums[++top] = -temp;
                } else {
                    nums[top] = operator == '*' ? nums[top] * temp : nums[top] / temp;
                }
            }
            temp = 0;
        }

        int res = 0;
        while (top != -1) {
            res += nums[top--];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("100+42"));
    }
}
