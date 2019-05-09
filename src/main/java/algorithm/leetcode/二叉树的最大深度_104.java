package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-17 21:50
 */
public class 二叉树的最大深度_104 {
    int result = 0;
    public int maxDepth(TreeNode root) {
       if (root == null) {
           return 0;
       }
       result = Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
       return result;
    }
}
