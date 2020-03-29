import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tostw
 * No.1162 地图分析
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();

        // 将所有陆地入队
        for (int i = 0, len1 = grid.length; i < len1; i++) {
            for (int j = 0, len2 = grid[i].length; j < len2; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 从每块陆地区域，一圈一圈遍历海洋，最后遍历到的海洋就是离陆地最远的海洋
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];

            // 取出队列元素，将其四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 0) {
                    continue;
                }
                // 距离+1
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        // 没有陆地或者没有海洋，返回-1
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离
        return grid[point[0]][point[1]] - 1;
    }
}

