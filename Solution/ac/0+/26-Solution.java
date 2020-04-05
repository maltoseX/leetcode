/**
 * @author tostw
 * No.26 删除排序数组中的重复项
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int l = 0;
        for (int r = 0; r < len; r++) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
        }

        return l + 1;
    }
}
