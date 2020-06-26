import java.util.*;

/**
 * @author tostw
 * No.139 单词拆分
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String str = wordDict.get(j);
                int strLen = str.length();
                if (strLen <= i && dp[i - strLen] && str.equals(s.substring(i - strLen, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}