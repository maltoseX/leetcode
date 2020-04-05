import java.util.Arrays;

/**
 * @author tostw
 * No.75 颜色分类
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;

        while (curr <= right) {
            if (nums[curr] == 0) {
                nums[curr] = nums[left];
                nums[left] = 0;
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1};
        new Solution().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}

