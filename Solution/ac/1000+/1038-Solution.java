import java.util.ArrayList;
import java.util.List;

/**
 * @author tostw
 * No.1038 从二叉搜索树到更大和树
 */
public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            sum(root, 0);
        }
        return root;
    }

    private int sum(TreeNode node, int num) {
        if (node.right != null) {
            num = sum(node.right, num);
        }
        num += node.val;
        node.val = num;
        if (node.left != null) {
            num = sum(node.left, node.val);
        }
        return num;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}