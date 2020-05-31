/**
 * @author tostw
 * No.101 对称二叉树
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftTreeNode, TreeNode rightTreeNode) {
        boolean flag;
        if (leftTreeNode == null && rightTreeNode == null) {
            return true;
        }

        if (leftTreeNode != null && rightTreeNode != null) {
            if (leftTreeNode.val == rightTreeNode.val) {
                return isSymmetric(leftTreeNode.left, rightTreeNode.right)
                        && isSymmetric(leftTreeNode.right, rightTreeNode.left);
            } else {
                return false;
            }
        }
        return false;
    }
}