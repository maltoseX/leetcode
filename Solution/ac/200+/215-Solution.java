import java.util.*;

/**
 * @author tostw
 * No.215 数组中的第K个最大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[l];
        }
        int i = l, j = r;
        int mid = nums[(l + r) >> 1];
        while (i <= j) {
            while (nums[i] < mid) {
                i++;
            }
            while (nums[j] > mid) {
                j--;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        if (j < nums.length - k) {
            return quickSort(nums, j + 1, r, k);
        }
        return quickSort(nums, l, j, k);
    }
}