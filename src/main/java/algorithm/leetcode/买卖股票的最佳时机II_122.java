package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-18 09:55
 */
public class 买卖股票的最佳时机II_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        boolean buyeState = false;
        int buyValue = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(i == prices.length -1 ) {
                if (buyeState) {
                    profit += prices[i] - buyValue;
                }
                break;
            }
            if (buyeState) {
                if (prices[i] >= prices[i+1]) {
                    profit += prices[i] - buyValue;
                    buyeState = false;
                }
            } else {
                if (prices[i] < prices[i+1]) {
                    buyeState = true;
                    buyValue = prices[i];
                }
            }
        }
       return profit;
    }

}
