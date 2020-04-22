import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * No.199 二叉树的右视图
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        backtrack(root, result, 1);
        return result;
    }

    private void backtrack(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (depth > list.size()) {
                list.add(node.val);
            }
            backtrack(node.right, list, depth + 1);
            backtrack(node.left, list, depth + 1);
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