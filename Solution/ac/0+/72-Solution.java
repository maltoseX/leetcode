
/**
 * @author tostw
 * No.72 编辑距离
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] distance = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j < len2 + 1; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int left = distance[i - 1][j] + 1;
                int down = distance[i][j - 1] + 1;
                int left_down = distance[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                distance[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }

        return distance[len1][len2];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new Solution().minDistance(word1, word2));
    }
}