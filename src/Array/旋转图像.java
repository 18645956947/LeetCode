package Array;

/**
 * leetcode -- 48. ��תͼ��
 * @author zhx
 */
public class ��תͼ�� {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        //�ȰѶ�ά����ת��
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //Ȼ���ٷ�תÿһ��
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
