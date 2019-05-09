package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-18 22:14
 */
public class 二叉树中的最大路径和_124 {
    private  int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        compute(root);
        return res;

    }

    private int compute(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = compute(root.left);
        int rMax = compute(root.right);
        res = Math.max(res, Math.max(0,lMax) + Math.max(0,rMax) + root.val);
        return Math.max(0,Math.max(lMax,rMax) + root.val);
    }
}
