package Dynamic_Programming;

/**
 * 01����-- ���仯����
 * @author zhx
 */
public class Knapsack {
    //����memo �����������á�0.������index������Ʒ��䱳���ݻ�ΪC���ܻ�õ�����ֵ   �д����n����Ʒ�� �� ������ǵ�ǰ���������ܳ��ص�����
    int[][] memo;

    public int knapsack01(int[] w, int[] v, int C){
        int n = w.length;
        //���鸳��ʼֵΪ -1
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
        //���־������һ����Ʒ���Ž�ȥ�ļ�ֵ
        int res = bestValue(w, v, index-1, c);
        if(c > w[index]){
            // v[index] + bestValue(w, v, index-1, c-w[index] ����������һ����Ʒ�Ž�ȥ�ļ�ֵ
            res = Math.max(res, v[index] + bestValue(w, v, index-1, c-w[index]));
        }
        //���仯����
        memo[index][c] = res;
        return res;
    }
}
