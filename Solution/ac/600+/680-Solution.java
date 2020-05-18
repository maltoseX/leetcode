/**
 * @author tostw
 * No.680 验证回文字符串II
 */

class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean validPalindrome(String s, int left, int right, int wrongCount) {
        if (wrongCount >= 2) {
            return false;
        }
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1, wrongCount + 1)
                        || validPalindrome(s, left + 1, right, wrongCount + 1);
            }
        }
        return true;
    }
}