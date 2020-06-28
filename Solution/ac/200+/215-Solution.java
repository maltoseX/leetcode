import java.util.*;

/**
 * @author tostw
 * No.215 数组中的第K个最大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}