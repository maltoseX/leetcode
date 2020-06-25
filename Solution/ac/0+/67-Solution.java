
import java.util.Arrays;

/**
 * @author tostw
 * 67. 二进制求和
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        int[] ans = new int[a.length()];
        int carry = 0;
        for (int i = 0; i < b.length(); i++) {
            char chA = a.charAt(a.length() - i - 1);
            char chB = b.charAt(b.length() - i - 1);

            int sum = chA + chB - 96;
            if (sum + carry > 1) {
                ans[i] = (sum + carry) % 2;
                carry = 1;
            } else {
                ans[i] = sum + carry;
                carry = 0;
            }
        }

        for (int i = b.length(); i < a.length(); i++) {
            int numA = a.charAt(a.length() - i - 1) - 48;
            if (numA + carry > 1) {
                ans[i] = 0;
                carry = 1;
            } else {
                ans[i] = numA + carry;
                carry = 0;
            }
        }

        StringBuilder res;
        if (carry == 1) {
            res = new StringBuilder("1");
        } else {
            res = new StringBuilder();
        }

        for (int i = ans.length - 1; i >= 0; i--) {
            res.append(ans[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }
}