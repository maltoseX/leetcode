/**
 * @author tostw
 * No.1422 分割字符串的最大得分
 */

class Solution {
    public int maxScore(String s) {
        int zeroCount = 0, oneCount = 0;
        int score = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }
            score = Math.max(score, zeroCount + oneCount);
        }
        return score;
    }

    public static void main(String[] args) {
        String s = "01001101";
        System.out.println(new Solution().maxScore(s));
    }
}