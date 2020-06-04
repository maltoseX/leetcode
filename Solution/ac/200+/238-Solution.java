import java.util.Arrays;

/**
 * @author tostw
 * No.238 除自身以外数组的乘积
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];

        output[0] = 1;
        for (int i = 1; i < len; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i];
        }

        return output;
    }
}