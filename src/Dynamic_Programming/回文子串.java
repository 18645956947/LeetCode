package Dynamic_Programming;

/**
 * leetcode - 647. �����Ӵ�
 * dp[i][j] ��ʾ���ַ� i  �� j �м��������Ӵ�
 * @author zhx
 */
public class �����Ӵ� {

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
