/**
 * @author tostw
 * No.572 另一个树的子树
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(3);
        TreeNode s2 = new TreeNode(4);
        TreeNode s3 = new TreeNode(5);
        TreeNode s4 = new TreeNode(1);
        TreeNode s5 = new TreeNode(2);

        s1.left = s2;
        s1.right = s3;
        s2.left = s4;
        s2.right = s5;

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;

        System.out.println(new Solution().isSubtree(s1, t1));
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
