package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3] 输出: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 * @author Stephen Cai
 * @date 2019-03-17 20:07
 */
public class 子集_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int j) {
        res.add(new ArrayList<>(tmp));
        for (int i = j; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
       new 子集_78().subsets(new int[]{1,2});
    }
}
