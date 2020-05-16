import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author tostw
 * No.145 二叉树的后序遍历
 */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }
}

