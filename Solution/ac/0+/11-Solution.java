/**
 * @author tostw
 * No.11 盛最多水的容器
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int level = Math.min(height[left], height[right]);
        int maxArea = (right - left) * level;
        while (left < right) {
            if (height[left] < height[right]) {
                do {
                    left++;
                } while (left < right && height[left] < level);
            } else {
                do {
                    right--;
                } while (left < right && height[right] < level);
            }
            level = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * level);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {10, 14, 10, 4, 10, 2, 6, 1, 6, 12};
        System.out.println(new Solution().maxArea(height));
    }
}