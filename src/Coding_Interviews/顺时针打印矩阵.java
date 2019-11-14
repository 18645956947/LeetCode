package Coding_Interviews;

import java.util.ArrayList;

/**
 * 转圈打印矩阵的思路就是把问题分解，找出打印一圈的规律，再找出打印圈数的边界条件，这题即可解出。
 * 每圈分为左上边界与右下边界的坐标点
 * 上边的打印从(a, b) -> (a, d - 1)
 * 右边的打印从(a, d) -> (c -1, d)
 * 下边的打印从(c, d) -> (c, b+1)
 * 左边的打印从(c, b) - > (a + 1, b)
 * @author zhx
 */
public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || (matrix.length == 0 && matrix[0].length == 0)){
            return res;
        }
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while(a <= c && b <= d){
            printEdge(res, matrix, a++, b++, c--, d--);
        }
        return res;
    }
    private static void printEdge(ArrayList<Integer> res, int[][] m, int a, int b, int c, int d){
        if(a == c){
            for(int i = b; i<= d;i++){
                res.add(m[a][i]);
            }
        }else if(b == d){
            for(int i = a; i <= c;i++){
                res.add(m[i][b]);
            }
        }else{
            for(int i = b;i <= d - 1;i++){
                res.add(m[a][i]);
            }
            for(int i = a;i <= c - 1;i++){
                res.add(m[i][d]);
            }
            for(int i = d;i >= b + 1;i--){
                res.add(m[c][i]);
            }
            for(int i = c;i >= a + 1;i--){
                res.add(m[i][b]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        ArrayList<Integer> list = 顺时针打印矩阵.printMatrix(matrix);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
