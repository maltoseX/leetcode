import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * No.113 路径总和II
 */

class Solution {
    List<List<Integer>> res;
    int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        this.sum = sum;
        dfs(root, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> path, int preSum) {
        if (node.left == null && node.right == null) {
            if (preSum + node.val == sum) {
                List<Integer> list = new ArrayList<>(path);
                list.add(node.val);
                res.add(list);
            }
        }

        preSum += node.val;
        if (node.left != null) {
            path.add(node.val);
            dfs(node.left, path, preSum);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.val);
            dfs(node.right, path, preSum);
            path.remove(path.size() - 1);
        }
    }
}

