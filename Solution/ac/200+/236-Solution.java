import java.util.*;

/**
 * @author tostw
 * No.236 二叉树的最近公共祖先
 */
class Solution {
    // 方法一：递归
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right, p, q);

        if ((lSon && rSon) || (node.val == p.val || node.val == q.val) && (lSon || rSon)) {
            ans = node;
        }

        return lSon || rSon || node.val == p.val || node.val == q.val;
    }

    // 方法二：存储父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs2(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs2(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs2(node.right);
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
