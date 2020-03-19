/**
 * @author tostw
 * No.409 最长回文串
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int result = 0;
        boolean flag = false;
        //'z' = 122, 'A' = 65, 122 - 64 = 58;
        char[] container = new char[58];
        for (char ch : chars) {
            container[ch - 'A']++;
        }

        for (char c : container) {
            if (!flag && c % 2 != 0) {
                result++;
                flag = true;
            }
            result += (c >> 1) << 1;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abcCccdd";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
