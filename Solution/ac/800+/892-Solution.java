
/**
 * @author tostw
 * No.892 三维形体的表面积
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int overlap = 0;
        int count = 0;
        for (int i = 0, len1 = grid.length; i < len1; i++) {
            for (int j = 0, len2 = grid[i].length; j < len2; j++) {
                count += grid[i][j];
                if (grid[i][j] > 1) {
                    overlap += (grid[i][j] - 1);
                }
                if (i > 0) {
                    overlap += Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (j > 0) {
                    overlap += Math.min(grid[i][j], grid[i][j - 1]);
                }
            }
        }

        return count * 6 - overlap * 2;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,2,2},
                {2,1,2},
                {2,2,2},
        };
        System.out.println(new Solution().surfaceArea(grid));
    }
}

