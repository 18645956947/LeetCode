package Dynamic_Programming;

/**
 * leetcode 714 - 买卖股票的最佳时机含手续费
 * @author zhx
 *  思路： 依旧是
 *  1.定义数组含义
 *  2.定义初始值
 *  3.定义关系
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
