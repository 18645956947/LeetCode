package Dynamic_Programming;

/**
 * leetcode - 62 ��ͬ·��
 * @author zhx
 * ˼·:�ȶ���һ����ά���� �����dp[i][j]  ����˼���Ǵ���ʼλ�� ��(i, j)��Ҫdp[i][j]���߷�
 * Ȼ����߽�������ֻ��һ�л���ֻ��һ�е����
 * ����ҳ���ϵ����Ԫ�ؼ�Ĺ�ϵʽ
 * һ���Ǵ� (i-1, j) ���λ����һ������
 *
 * һ���Ǵ�(i, j - 1) ���λ����һ������
 *
 * ��Ϊ�Ǽ������п��ܵĲ��裬�����ǰ����п����ߵ�·���������������Թ�ϵʽ�� dp[i] [j] = dp[i-1] [j] + dp[i] [j-1]��
 */
public class ��ͬ·�� {
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
