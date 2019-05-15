package Dynamic_Programming;

/**
 * 718. ��ظ�������
 * @author zhx
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        //dp[i][j]��ʾ��A[i - 1] == B[j - 1]ʱ��A[0, i -1],B[0, j - 1]�������ظ������鳤�ȡ�
        int dp[][] = new int[1001][1001];
        for(int i = 0;i<A.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<B.length;i++){
            dp[0][i] = 0;
        }
        int res = 0;
        for(int i = 1;i<=A.length;i++){
            for(int j = 1;j<=B.length;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
