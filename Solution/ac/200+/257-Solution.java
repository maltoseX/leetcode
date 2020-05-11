import java.util.*;

/**
 * @author tostw
 * No.257 二叉树的所有路径
 */
class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(new StringBuilder(), root);
        return res;
    }

    private void dfs(StringBuilder path, TreeNode node) {
        if (node.left == null && node.right == null) {
            res.add(path.append(node.val).toString());
            return;
        }

        if (node.left != null) {
            int len = path.length();
            dfs(path.append(node.val).append("->"), node.left);
            path.delete(len, path.length());
        }
        if (node.right != null) {
            dfs(path.append(node.val).append("->"), node.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}