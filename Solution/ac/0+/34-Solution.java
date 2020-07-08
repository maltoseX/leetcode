import java.util.*;

/**
 * @author tostw
 * No.34 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int leftIndex = extremeInsertionIndex(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return res;
        }

        res[0] = leftIndex;
        res[1] = extremeInsertionIndex(nums, target, false) - 1;

        return res;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 6)));
    }
}