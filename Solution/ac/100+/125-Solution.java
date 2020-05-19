import java.util.*;

/**
 * @author tostw
 * No.125 验证回文串
 */

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (!(s.charAt(left) >= 'a' && s.charAt(left) <= 'z' || s.charAt(left) >= '0' && s.charAt(left) <= '9')) {
                if (left < right) {
                    left++;
                } else {
                    return true;
                }
            }
            while (!(s.charAt(right) >= 'a' && s.charAt(right) <= 'z' || s.charAt(right) >= '0' && s.charAt(right) <= '9')) {
                if (left < right) {
                    right--;
                } else {
                    return true;
                }
            }

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new Solution().isPalindrome(s));
    }
}