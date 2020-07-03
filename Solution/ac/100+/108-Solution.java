import java.util.*;

/**
 * @author tostw
 * No.108 将有序数组转换为二叉搜索树
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return setChildNode(nums, 0, nums.length - 1);
    }

    private TreeNode setChildNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = setChildNode(nums, start, mid - 1);
        root.right = setChildNode(nums, mid + 1, end);
        return root;
    }
}