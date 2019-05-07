package Dynamic_Programming;
/**
 * 343. 整数拆分
 * @author zhx
 * 备忘录方法  自顶向下
 */
public class IntegerBreak {
    private int[] memo;
    public int integerBreak(int n) {
        if(n < 1){
            return -1;
        }
        memo = new int[n+1];
        for(int i = 0;i<n+1;i++){
            memo[i] = -1;
        }
        return breakInteger(n);
    }

    private int breakInteger(int n){
        if(n == 1){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int res = -1;
        for(int i = 1;i<=n-1;i++){
            // i + n-i
            res = max3( res, i * (n-i), i * breakInteger(n-i) );
        }
        memo[n] = res;
        return res;


    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    /**
     * 动态规划 自底向上
     * @param n
     * @return
     */
    public int integerBreak_02(int n) {
        if(n < 1){
            return -1;
        }
        memo = new int[n+1];
        memo[1] = 1;

        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i-1;j++){
                //j + i-j
                memo[i] = max3(memo[i], j * (i-j), j * memo[i-j]);

            }
        }
        return memo[n];
    }
}
