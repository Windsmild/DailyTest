package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-06 10:17
 */
public class 二叉搜索树的最近公共祖先_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q =tmp;
        }
        TreeNode node = root;
        while (node != null) {
            if (q.val < node.val) {
                node =node.left;
            } else if (p.val > node.val) {
                node = node.right;
            } else {
                return node;
            }
         }
         return null;

    }
}
