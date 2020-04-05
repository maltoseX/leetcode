import java.util.Arrays;

/**
 * @author tostw
 * No.31 下一个排列
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        int left = len - 2, right = len - 1;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left == -1) {
            left = 0;
        } else if (left >= 0) {
            while (left < right && nums[left] >= nums[right]) {
                right--;
            }
            swap(nums, left, right);
            left++;
            right = len - 1;
        }

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 4, 3, 2, 1};
        // expect [1,2,3,4,5]
//        int[] nums = {1, 5, 4, 3, 2};
        // expect [2,1,3,4,5]
//        int[] nums = {2, 1, 5, 4, 3};
        // expect [2,3,1,4,5]
//        int[] nums = {3, 5, 4, 2, 1};
        // expect [4,1,2,3,5]
//        int[] nums = {2, 3, 4, 5, 1};
        // expect [2,3,5,1,4]
//        int[] nums = {1, 5, 1};
        // expect [5,1,1]
        int[] nums = {5, 1, 1};
        // expect [1,1,5]
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
