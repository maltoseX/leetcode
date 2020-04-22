/**
 * @author tostw
 * No.1248 统计「优美子数组」
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int result = 0;
        int odd = 0;
        int start = 0, end = 0;
        while (end < len) {
            if ((nums[end++] & 1) == 1) {
                odd++;
            }
            if (odd == k) {
                int tmp = end;
                while (end < len && (nums[end] & 1) == 0) {
                    end++;
                }
                int leftCount = 0;
                while ((nums[start] & 1) == 0) {
                    leftCount++;
                    start++;
                }

                result += (leftCount + 1) * (end - tmp + 1);
                start++;
                odd--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(new Solution().numberOfSubarrays(nums, 2));
    }
}