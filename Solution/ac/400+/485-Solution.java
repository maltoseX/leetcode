
/**
 * @author tostw
 * No.485 最大连续1的个数
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max,curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        return Math.max(max, curr);
    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(new Solution().findMaxConsecutiveOnes(a));
    }
}