/**
 * @author tostw
 * No.174 地下城游戏
 */

class Solution {
    // 从右下往左上遍历
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] lowestHP = new int[row][col];

        lowestHP[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);

        for (int i = col - 2; i >= 0; i--) {
            lowestHP[row - 1][i] = Math.max(1, lowestHP[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int i = row - 2; i >= 0; i--) {
            lowestHP[i][col - 1] = Math.max(1, lowestHP[i + 1][col - 1] - dungeon[i][col - 1]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                lowestHP[i][j] = Math.max(1, Math.min(lowestHP[i + 1][j], lowestHP[i][j + 1]) - dungeon[i][j]);
            }
        }

        return lowestHP[0][0];
    }

    // 一维dp数组
    public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[] lowestHP = new int[col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    lowestHP[j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == row - 1 && j != col - 1) {
                    lowestHP[j] = Math.max(1, lowestHP[j + 1] - dungeon[i][j]);
                } else if (i != row - 1 && j == col - 1) {
                    lowestHP[j] = Math.max(1, lowestHP[j] - dungeon[i][j]);
                } else {
                    lowestHP[j] = Math.max(1, Math.min(lowestHP[j], lowestHP[j + 1]) - dungeon[i][j]);
                }
            }
        }

        return lowestHP[0];
    }
}


