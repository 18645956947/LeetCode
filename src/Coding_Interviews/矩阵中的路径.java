package Coding_Interviews;

/**
 * 剑指offer - 矩阵中的路径
 * @author zhx
 */
public class 矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] a = new boolean[matrix.length];
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols; j++){
                if(helper(matrix, i, j, rows, cols, a, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int i, int j, int rows,
                           int cols,  boolean[] a, char[] str, int k){
        int index = i * cols + j;
        if(i<0 || j< 0|| i >= rows || j >= cols || matrix[index] != str[k] || a[index] == true){
            return false;
        }
        if(k == str.length - 1){
            return true;
        }
        a[index] = true;
        if(helper(matrix, i - 1, j, rows, cols, a, str, k+1) ||
                helper(matrix, i + 1, j, rows, cols, a, str, k+1) ||
                helper(matrix, i, j - 1, rows, cols, a, str, k+1) ||
                helper(matrix, i, j + 1, rows, cols, a, str, k+1) ){
            return true;
        }
        a[index] = false;
        return false;
    }

}
