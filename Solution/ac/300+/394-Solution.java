
/**
 * @author tostw
 * No.394 字符串解码
 */

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                i += decode(sb, i);
            }
            i++;
        }
        return sb.toString();
    }

    private int decode(StringBuilder sb, int start) {
        int left = start;
        while (left < sb.length() && sb.charAt(left) != '[') {
            left++;
        }
        int repeatTimes = Integer.parseInt(sb.substring(start, left));

        int right = left + 1;
        while (right < sb.length()) {
            if (sb.charAt(right) >= '0' && sb.charAt(right) <= '9') {
                right += decode(sb, right);
            } else if (sb.charAt(right) == ']') {
                break;
            }
            right++;
        }
        String repeatStr = sb.substring(left + 1, right);
        StringBuilder decodeStr = new StringBuilder();
        for (int j = 0; j < repeatTimes; j++) {
            decodeStr.append(repeatStr);
        }

        sb.replace(start, right + 1, decodeStr.toString());
        return repeatTimes * repeatStr.length() - 1;
    }
}