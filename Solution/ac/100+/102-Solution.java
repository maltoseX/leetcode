import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * No.102 二叉树的层序遍历
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        updateValue(root, 0);
        return res;
    }

    private void updateValue(TreeNode node, int i) {
        if (node != null) {
            if (res.size() == i) {
                res.add(new ArrayList<>());
            }
            res.get(i).add(node.val);

            updateValue(node.left, i + 1);
            updateValue(node.right, i + 1);
        }
    }
}

