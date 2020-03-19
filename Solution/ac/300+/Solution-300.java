
/**
 * @author tostw
 * No.300 最长上升子序列
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] incrSubs = new int[nums.length];
        incrSubs[0] = nums[0];
        int maxLen = 1;

        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] > incrSubs[maxLen - 1]) {
                incrSubs[maxLen] = nums[i];
                maxLen++;
            } else {
                int l = 0, r = maxLen - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (incrSubs[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                incrSubs[l] = nums[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2};
        int s = new Solution().lengthOfLIS(a);
        System.out.println(s);
    }
}
