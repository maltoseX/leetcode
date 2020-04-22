/**
 * @author tostw
 * No.1351 统计有序矩阵中的负数
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int t = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < t; j++) {
                if (grid[i][j] < 0) {
                    count += (t - j) * (m - i);
                    t = j;
                }
            }
        }
        return count;
    }
}