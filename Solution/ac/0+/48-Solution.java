
/**
 * @author tostw
 * No.48 旋转图像
 * 面试题 01.07 旋转矩阵
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n % 2 == 0 ? n / 2 : n / 2 + 1); j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1, 2, 3, 4},
//                {2, 3, 4, 5},
//                {3, 4, 5, 6},
//                {4, 5, 6, 7},
//                {1, 2, 3, 4, 5},
//                {2, 3, 4, 5, 6},
//                {3, 4, 5, 6, 7},
//                {4, 5, 6, 7, 8},
//                {5, 6, 7, 8, 9}
                {1}
        };
        new Solution().rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
