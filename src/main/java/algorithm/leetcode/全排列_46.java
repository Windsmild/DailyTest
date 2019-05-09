package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * @author Stephen Cai
 * @date 2019-03-16 10:18
 */
public class 全排列_46 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<List<Integer>>();
        helper(nums, 0);
        return res;

    }


    public void helper(int[] nums, int i) {
        if (i == nums.length - 1) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i,j);
            helper(nums, i + 1);
            swap(nums,i,j);


        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //递归方法
    public List<List<Integer>> recursionPermute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(res,temp,nums,used);
                temp.remove(temp.size() -1);
                used[i] =false;
            }
        }
    }

    public static void main(String[] args) {
        new 全排列_46().recursionPermute(new int[]{1,2,3});
        new 全排列_46().permute(new int[]{1,2,3});
    }
}
