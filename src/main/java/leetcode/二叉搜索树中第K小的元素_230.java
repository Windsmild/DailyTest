package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-02 22:44
 */
public class 二叉搜索树中第K小的元素_230 {
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+count(root.left) + count(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        int num = count(root.left);
        if (num == k-1) {
            return root.val;
        }
        if (num > k-1) {
            return kthSmallest(root.left,k);
        }
        return kthSmallest(root.right,k-num-1);
    }
}
