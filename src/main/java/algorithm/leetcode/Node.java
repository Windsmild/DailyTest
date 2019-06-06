package algorithm.leetcode;

import java.util.List;

/**
 * @author Stephen Cai
 * @date 2019-05-14 09:28
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
