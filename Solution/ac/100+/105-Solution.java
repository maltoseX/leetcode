import java.util.*;

/**
 * @author tostw
 * No.105 从前序与中序遍历序列构造二叉树
 */

class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int
            preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorderRoot = preorderLeft;
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;

        // 递归地构建左子树，并连接到根节点
        // 先序遍历中“从 左边界+1 开始的 sizeLeftSubTree”个元素就对应了中序遍历中“从 左边界 开始到 根节点定位-1”的元素
        root.left = myBuildTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + sizeLeftSubtree,
                inorderLeft, inorderRoot - 1);

        // 递归地构建右子树，并连接到根节点
        // 先序遍历中“从 左边界+1+左子树节点数目 开始到 右边界”的元素就对应了中序遍历中“从 根节点定位+1 到右边界”的元素
        root.right = myBuildTree(preorder, inorder,
                preorderLeft + sizeLeftSubtree + 1, preorderRight,
                inorderRoot + 1, inorderRight);

        return root;
    }
}