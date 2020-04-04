/**
 * @author tostw
 * No.42 接雨水
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            int level = Math.min(height[left], height[right]);
            if (height[left] == level) {
                while (left < right && level > height[++left]) {
                    result += level - height[left];
                }
            } else if (height[right] == level) {
                while (left < right && level > height[--right]) {
                    result += level - height[right];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] height = {5, 2, 4};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        System.out.println(new Solution().trap(height));
    }
}
