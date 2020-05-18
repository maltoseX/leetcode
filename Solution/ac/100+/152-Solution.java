/**
 * @author tostw
 * No.152 乘积最大子数组
 */

public class Solution {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                int tmp = imax;
                imax = Math.max(imin * nums[i], nums[i]);
                imin = Math.min(tmp * nums[i], nums[i]);
            } else if (nums[i] == 0) {
                imax = 1;
                imin = 1;
                max = Math.max(max, 0);
                continue;
            }
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.println(new Solution().maxProduct(nums));
    }
}