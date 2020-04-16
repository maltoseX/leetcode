/**
 * @author tostw
 * No.55 跳跃游戏
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        } else if (len == 1) {
            return true;
        }

        int distance = 1;
        for (int i = len - 2; i > 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
        }

        return nums[0] >= distance;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution().canJump(nums));
    }
}