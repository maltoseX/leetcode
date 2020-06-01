import java.util.Arrays;

/**
 * @author tostw
 * No.73 矩阵置零
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowSetZero = false;
        boolean firstColSetZero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (i == 0) {
                        firstRowSetZero = true;
                    }
                    matrix[0][j] = 0;
                    if (j == 0) {
                        firstColSetZero = true;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            if (firstRowSetZero) {
                Arrays.fill(matrix[0], 0);
            }
            if (firstColSetZero) {
                for (int j = 1; j < m; j++) {
                    matrix[j][0] = 0;
                }
            }
        }
    }
}