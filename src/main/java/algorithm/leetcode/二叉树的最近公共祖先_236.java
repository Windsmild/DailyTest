package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-06 10:22
 */
public class 二叉树的最近公共祖先_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果找到 p 或者 q 那么就没有必要接着递归，因为共同祖先只可能是该节点或该节点祖先
        //如果 root 为空了，说明这条路径上不可能有 p 或 q 节点，返回空
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }

    }
}
