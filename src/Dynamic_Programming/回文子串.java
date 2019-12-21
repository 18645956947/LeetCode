package Dynamic_Programming;

/**
 * leetcode - 647. 回文子串
 * dp[i][j] 表示从字符 i  到 j 有几个回文子串
 * @author zhx
 */
public class 回文子串 {

    public int countSubstrings(String s) {

        int n = s.length();
        int res = 0;
        int[][] dp = new int[n][n];
        for(int i = n - 1;i >= 0;i--){
            for(int j = i;j < n;j++){
                if((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                    res++;
                }
            }
        }
        return res;
    }
}
