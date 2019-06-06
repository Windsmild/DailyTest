package algorithm.leetcode;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @author Stephen Cai
 * @date 2019-05-14 09:26
 */
public class N叉树的最大深度_559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int dep = 0;
        for (Node child: root.children) {
            int d = maxDepth(child);
            dep = Math.max(dep, d);
        }
        return dep+1;

    }
}
