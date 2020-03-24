
/**
 * @author tostw
 * No.198 打家劫舍
 */
public class Solution {
    public int rob(int[] nums)  {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currMax = 0;
        int prevMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + num);
            prevMax = temp;
        }
        return currMax;
    }
}

