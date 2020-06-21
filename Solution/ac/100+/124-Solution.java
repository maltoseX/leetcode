/**
 * @author tostw
 * No.124 二叉树中的最大路径和
 */
public class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(maxSum, (node.val + leftGain + rightGain));
        return node.val + Math.max(leftGain, rightGain);
    }
}