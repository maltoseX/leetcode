import java.util.*;

/**
 * @author tostw
 * No.378 有序矩阵中第K小的元素
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, len)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int len) {
        int i = len - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}