/**
 * @author tostw
 * No.867 转置矩阵
 */

class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] B = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[j][i] = A[i][j];
            }
        }

        return B;
    }
}