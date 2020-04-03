
/**
 * @author tostw
 * No.8 字符串转换整数(atoi)
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int i = 0;
        boolean negative = false;
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        if (str.charAt(i) < '0') {
            if (str.charAt(i) == '-') {
                negative = true;
            } else if (str.charAt(i) != '+') {
                return 0;
            }
            if (len == 1) {
                return 0;
            }
            i++;
        } else if (str.charAt(i) > '9') {
            return 0;
        }
        int result = 0;
        while (i < len && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return negative ? -result : result;
    }
}
