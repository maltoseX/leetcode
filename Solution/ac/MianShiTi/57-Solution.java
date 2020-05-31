/**
 * @author tostw
 * 面试题57. 和为s的两个数字
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) {
            return null;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == nums.length - 1) {
                break;
            }
            if (nums[mid] <= target && nums[mid + 1] > target) {
                break;
            } else if (nums[mid + 1] <= target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        left = 0;
        right = mid;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}