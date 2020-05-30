import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author tostw
 * No.84 柱状图中最大的矩形
 * 注：建议使用Deque代替Stack
 * https://mp.weixin.qq.com/s/Ba8jrULf8NJbENK6WGrVWg
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        return dfs(heights, 0, heights.length - 1);
    }

    public int dfs(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }
        int maxArea;
        int lowestIndex = left;
        boolean sorted = true;
        for (int i = left; i <= right; i++) {
            if (i > 0 && heights[i] < heights[i - 1]) {
                sorted = false;
            }
            lowestIndex = heights[i] < heights[lowestIndex] ? i : lowestIndex;
        }
        maxArea = (right - left + 1) * heights[lowestIndex];
        if (sorted) {
            for (int i = left; i <= right; i++) {
                maxArea = Math.max(maxArea, (right - i + 1) * heights[i]);
            }
            return maxArea;
        }
        maxArea = Math.max(maxArea, dfs(heights, left, lowestIndex - 1));
        maxArea = Math.max(maxArea, dfs(heights, lowestIndex + 1, right));
        return maxArea;
    }

    // 方法二：单调栈
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {6, 7, 5, 2, 4, 2, 9, 3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}