import java.util.*;

/**
 * @author tostw
 * No.112 路径总和
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return fun(root, sum);
    }

    private boolean fun(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (sum - node.val == 0 && node.left == null && node.right == null) {
            return true;
        }

        return fun(node.left, sum - node.val)
                || fun(node.right, sum - node.val);

    }
}