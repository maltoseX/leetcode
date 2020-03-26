
/**
 * @author tostw
 * No.999 车的可用捕获量
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        int pX = 0;
        int pY = 0;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    pX = j;
                    pY = i;
                }
            }
        }
        count += search(board, pX, pY, -1, 0);
        count += search(board, pX, pY, 1, 0);
        count += search(board, pX, pY, 0, -1);
        count += search(board, pX, pY, 0, 1);

        return count;
    }

    private int search(char[][] board, int pX, int pY, int x, int y) {
        if (x == 0) {
            while (pY + y >= 0 && pY + y <= 7) {
                pY += y;
                if (board[pY][pX] == 'p') {
                    return 1;
                } else if (board[pY][pX] == 'B') {
                    return 0;
                }
            }
        } else {
            while (pX + x >= 0 && pX + x <= 7) {
                pX += x;
                if (board[pY][pX] == 'p') {
                    return 1;
                } else if (board[pY][pX] == 'B') {
                    return 0;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println(new Solution().numRookCaptures(board));
    }
}

