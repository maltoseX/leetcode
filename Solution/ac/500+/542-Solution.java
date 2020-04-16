import java.util.Stack;

/**
 * @author tostw
 * No.542 01矩阵
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int distance;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j] == 1) {
                    distance = 1;
                    while (!findZeroWithinRange(matrix, i, j, distance)) {
                        distance++;
                    }
                    matrix[i][j] = distance;
                }
            }
        }
        return matrix;
    }

    private boolean findZeroWithinRange(int[][] matrix, int i, int j, int distance) {
        boolean flag = search(matrix, i, j + distance, 1, -1, distance);
        flag = flag || search(matrix, i + distance, j, -1, -1, distance);
        flag = flag || search(matrix, i, j - distance, -1, 1, distance);
        flag = flag || search(matrix, i - distance, j, 1, 1, distance);
        return flag;
    }

    private boolean illegal(int[][] matrix, int i, int j) {
        return i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length;
    }

    private boolean search(int[][] matrix, int i, int j, int vi, int vj, int distance) {
        for (int k = 0; k < distance; k++) {
            if (!illegal(matrix, i, j)) {
                if (matrix[i][j] == 0) {
                    return true;
                }
            }
            i += vi;
            j += vj;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
        };
        new Solution().updateMatrix(matrix);
    }
}