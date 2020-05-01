import java.util.HashMap;
import java.util.Map;

/**
 * @author tostw
 * No.3 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = new char[128];
        int len = s.length();
        int left = 0, right = 0, maxLen = 0;
        while (right<len){
            char c = s.charAt(right);
            chs[c]++;

            while (chs[c]>1){
                char cl = s.charAt(left);
                chs[cl]--;
                left++;
            }
            maxLen = Math.max(right-left+1,maxLen);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "au";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}