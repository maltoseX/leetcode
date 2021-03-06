/**
 * @author tostw
 * No.10 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] f = new boolean[sLen + 1][pLen + 1];
        f[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[sLen][pLen];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {

        // 最复杂情况
        // s="abacadaeaf"
        // p=".*e.*"
        String s = "mississippi";
        String p = "mis*is*ip*.";
        System.out.println(new Solution().isMatch(s, p));
    }
}