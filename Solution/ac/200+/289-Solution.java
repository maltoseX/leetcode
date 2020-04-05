import java.util.Arrays;

/**
 * @author tostw
 * No.289 生命游戏
 */
public class Solution {
    // 方法二：使用额外的状态
    // 方法一中 O(mn)O(mn) 的空间复杂度在数组很大的时候内存消耗是非常昂贵的。题目中每个细胞只有两种状态 live(1) 或 dead(0)，
    // 但我们可以拓展一些复合状态使其包含之前的状态。举个例子，如果细胞之前的状态是 0，但是在更新之后变成了 1，
    // 我们就可以给它定义一个复合状态 2（二进制“10”）。这样我们看到 2，既能知道目前这个细胞是活的，还能知道它之前是死的。

    //    具体算法
    //    遍历 board 中的细胞。
    //    根据数组的细胞状态计算新一轮的细胞状态，这里会用到能同时代表过去状态和现在状态的复合状态。
    //    具体的计算规则如下所示：
    //    规则 1：如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡。这时候，将细胞值改为 -1，代表这个细胞过去是活的现在死了；
    //    规则 2：如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活。这时候不改变细胞的值，仍为 1；
    //    规则 3：如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡。这时候，将细胞的值改为 -1，代表这个细胞过去是活的现在死了。可以看到，因为规则 1 和规则 3 下细胞的起始终止状态是一致的，因此它们的复合状态也一致；
    //    规则 4：如果死细胞周围正好有三个活细胞，则该位置死细胞复活。这时候，将细胞的值改为 2，代表这个细胞过去是死的现在活了。
    //    根据新的规则更新数组；
    //    现在复合状态隐含了过去细胞的状态，所以我们可以在不复制数组的情况下完成原地更新；
    //    对于最终的输出，需要将 board 转成 0，1 的形式。因此这时候需要再遍历一次数组，将复合状态为 2 的细胞的值改为 1，复合状态为 -1 的细胞的值改为 0。

    public void gameOfLife(int[][] board) {

        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };

        new Solution().gameOfLife(board);

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
