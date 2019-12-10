package Dynamic_Programming;

/**
 * leetcode - 62 不同路径
 * @author zhx
 * 思路:先定义一个二维数组 这个题dp[i][j]  的意思就是从起始位置 到(i, j)需要dp[i][j]种走法
 * 然后处理边界条件，只有一行或者只有一列的情况
 * 最后找出关系数组元素间的关系式
 * 一种是从 (i-1, j) 这个位置走一步到达
 *
 * 一种是从(i, j - 1) 这个位置走一步到达
 *
 * 因为是计算所有可能的步骤，所以是把所有可能走的路径都加起来，所以关系式是 dp[i] [j] = dp[i-1] [j] + dp[i] [j-1]。
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
