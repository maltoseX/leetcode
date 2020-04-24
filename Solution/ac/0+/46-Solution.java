package no316;

/**
 * @author tostw
 * No.316 去除重复字母
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int[] freq = new int[26];
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            char ch = sb.charAt(i);
            if (freq[ch - 'a'] > 1) {
                if (i == len - 1 || ch > sb.charAt(i + 1)) {
                    sb.replace(i, i + 1, " ");
                    freq[ch - 'a']--;
                }
            }
        }

        return sb.toString().replaceAll(" ", "");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
    }
}