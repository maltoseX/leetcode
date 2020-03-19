
/**
 * @author tostw
 * No.695 岛屿的最大面积(DFS算法)
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0, len1 = grid.length; i < len1; i++) {
            for (int j = 0, len2 = grid[i].length; j < len2; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        // 沉岛
        grid[i][j] = 0;
        int area = 1;
        area += dfs(i + 1, j, grid);
        area += dfs(i - 1, j, grid);
        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);
        return area;
    }
}
