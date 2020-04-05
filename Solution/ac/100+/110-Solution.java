/**
 * @author tostw
 * No.110 平衡二叉树
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class NodeInfo {
        int depth;
        boolean balanced;

        public NodeInfo(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
    }

    NodeInfo isBalancedNode(TreeNode node) {
        if (node == null) {
            return new NodeInfo(-1, true);
        }

        NodeInfo leftInfo = isBalancedNode(node.left);
        if (!leftInfo.balanced) {
            return new NodeInfo(-1, false);
        }
        NodeInfo rightInfo = isBalancedNode(node.right);
        if (!rightInfo.balanced) {
            return new NodeInfo(-1, false);
        }

        if (Math.abs(leftInfo.depth - rightInfo.depth) < 2) {
            return new NodeInfo((Math.max(leftInfo.depth, rightInfo.depth) + 1), true);
        } else {
            return new NodeInfo(-1, false);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedNode(root).balanced;
    }

}
