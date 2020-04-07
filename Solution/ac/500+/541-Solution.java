/**
 * @author tostw
 * No.541 反转字符串II
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0, len = s.length(); i < len; i += 2 * k) {
            reverse(chars, i, Math.min(i + k - 1, len - 1));
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        for (; i < j; ++i, --j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {

        String s = "a";
        System.out.println(new Solution().reverseStr(s, 2));
    }
}