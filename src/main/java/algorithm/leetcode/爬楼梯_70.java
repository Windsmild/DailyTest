package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen Cai
 * @date 2019-03-17 19:15
 */
public class 爬楼梯_70 {
    Map<Integer,Integer> numMap = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return (climbStairs(n - 1) + climbStairs(n - 2));
    }

    public int arrayClimbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 ) {
            return 1;
        }
        if (n == 2 ) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int res =new 爬楼梯_70().climbStairs(42);
        int res1 =new 爬楼梯_70().arrayClimbStairs(42);
        System.out.println(res);
        System.out.println(res1);
    }
}
