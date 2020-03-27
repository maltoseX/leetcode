/**
 * @author tostw
 * No.200 岛屿数量
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int num = 0;

        for (int i = 0, len1 = grid.length; i < len1; i++) {
            for (int j = 0, len2 = grid[0].length; j < len2; j++) {
                if (grid[i][j] == '1') {
                    sunkLand(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void sunkLand(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            if (grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            sunkLand(grid, i, j + 1);
            sunkLand(grid, i + 1, j);
            sunkLand(grid, i, j - 1);
            sunkLand(grid, i - 1, j);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(new Solution().numIslands(grid));
    }
}

