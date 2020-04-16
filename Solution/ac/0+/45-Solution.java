/**
 * @author tostw
 * No.45 跳跃游戏II
 */
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int freq = 0;
        int index = 0;
        while (index + nums[index] < len - 1) {
            int maxRangeIndex = index;
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (i + nums[i] > maxRangeIndex + nums[maxRangeIndex]) {
                    maxRangeIndex = i;
                }
            }
            index = maxRangeIndex;
            freq++;
        }
        return ++freq;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 3, 1, 1, 1};
        System.out.println(new Solution().jump(nums));
    }
}