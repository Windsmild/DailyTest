package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-17 22:22
 */
public class 买卖股票的最佳时机_121 {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin,prices[i]);
            max = Math.max(max,prices[i] -curMin);
        }
        return max;
    }
}
