import java.util.Arrays;

/**
 * @author tostw
 * 面试题40. 最小的K个数
 * BFPRT算法原理(快排优化)
 * https://zhuanlan.zhihu.com/p/31498036
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        halfQuickSort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void halfQuickSort(int[] arr, int k, int left, int right) {
        if (left >= right || arr.length <= 1) {
            return;
        }
        int i = left, j = right, pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        if (j >= k) {
            halfQuickSort(arr, k, left, j);
        } else {
            halfQuickSort(arr, k, i, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 1};
        int k = 1;
        int[] result = new Solution().getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
