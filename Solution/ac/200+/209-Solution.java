import java.util.*;

/**
 * @author tostw
 * No.209 长度最小的子数组
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}