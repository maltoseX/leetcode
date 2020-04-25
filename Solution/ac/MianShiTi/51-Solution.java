import java.util.Arrays;

/**
 * @author tostw
 * 面试题51. 数组中的逆序对
 */
class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int count = 0;
        int[] newArr = new int[len];
        for (int i = 2; i < len * 2; i *= 2) {
            for (int j = 0; j < (len + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= len ? (len - 1) : left + i / 2;
                int right = i * (j + 1) - 1 >= len ? (len - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;

                while (l < mid && m <= right) {
                    if (nums[l] <= nums[m]) {
                        count += m - mid;
                        newArr[start++] = nums[l++];
                    } else {
                        newArr[start++] = nums[m++];
                    }
                }

                while (l < mid) {
                    count += m - mid;
                    newArr[start++] = nums[l++];
                }
                while (m <= right) {
                    newArr[start++] = nums[m++];
                }

                System.arraycopy(newArr, left, nums, left, right - left + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(new Solution().reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}