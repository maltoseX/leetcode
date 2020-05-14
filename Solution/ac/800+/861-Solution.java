import java.util.Arrays;

/**
 * @author tostw
 * No.861 翻转矩阵后的得分
 */

class Solution {
    int[][] A;

    public int matrixScore(int[][] A) {
        this.A = A;
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                flipRow(i);
            }
        }

        for (int i = 0; i < col; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][i] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero > one) {
                flipCol(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            int temp = 0;
            for (int j = 0; j < col; j++) {
                temp = temp * 2 + A[i][j];
            }
            sum += temp;
        }
        return sum;
    }

    private void flipRow(int row) {
        for (int i = 0; i < A[0].length; i++) {
            A[row][i] ^= 1;
        }
    }

    private void flipCol(int col) {
        for (int i = 0; i < A.length; i++) {
            A[i][col] ^= 1;
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new Solution().matrixScore(a));
//        a = new Solution().matrixScore(a);
//        for (int[] ints : a) {
//            System.out.println(Arrays.toString(ints));
//        }
    }
}

