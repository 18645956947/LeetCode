package Dynamic_Programming;

/**
 * 01背包-- 记忆化搜索
 * @author zhx
 */
public class Knapsack {
    //数组memo 整体代表的是用【0.。。。index】的物品填充背包容积为C所能获得的最大价值   行代表第n个物品， 列 代表的是当前背包的所能承载的重量
    int[][] memo;

    public int knapsack01(int[] w, int[] v, int C){
        int n = w.length;
        //数组赋初始值为 -1
        memo = new int[n][C+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < C+1; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, n-1, C);
    }

    private int bestValue(int[] w, int[] v, int index, int c){
        if(index < 0 || c <= 0){
            return 0;
        }
        if(memo[index][c] != -1){
            return memo[index][c];
        }
        //这种就是最后一个物品不放进去的价值
        int res = bestValue(w, v, index-1, c);
        if(c > w[index]){
            // v[index] + bestValue(w, v, index-1, c-w[index] 代表的是最后一个物品放进去的价值
            res = Math.max(res, v[index] + bestValue(w, v, index-1, c-w[index]));
        }
        //记忆化数组
        memo[index][c] = res;
        return res;
    }
}
