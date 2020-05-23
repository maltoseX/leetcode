/**
 * @author tostw
 * No.76 最小覆盖子串
 */

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int left = 0, right = 0;
        int ansL = 0, ansR = 0;
        int match = 0;
        int minLen = s.length() + 1;

        while (right < s.length()) {
            char rch = s.charAt(right);
            freq[rch]--;
            if (freq[rch] >= 0) {
                match++;
            }
            right++;

            while (match == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    ansL = left;
                    ansR = right;
                }
                char lch = s.charAt(left);
                freq[lch]++;

                if (freq[lch] > 0) {
                    match--;
                }
                left++;
            }
        }
        return s.substring(ansL, ansR);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("a", "b"));
    }
}