package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author Stephen Cai
 * @date 2019-03-17 17:48
 */
public class 最大子序和_53 {
    public int maxSubArray(int[] nums) {
     int sum =0,max =Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum <0 ? nums[i] : (sum + nums[i]);
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
