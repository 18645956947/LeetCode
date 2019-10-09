package Array;

/**
 * leetcode -- 48. 旋转图像
 * @author zhx
 */
public class 旋转图像 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        //先把二维矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //然后再反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
