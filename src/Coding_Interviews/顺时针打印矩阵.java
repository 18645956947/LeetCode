package Coding_Interviews;

import java.util.ArrayList;

/**
 * תȦ��ӡ�����˼·���ǰ�����ֽ⣬�ҳ���ӡһȦ�Ĺ��ɣ����ҳ���ӡȦ���ı߽����������⼴�ɽ����
 * ÿȦ��Ϊ���ϱ߽������±߽�������
 * �ϱߵĴ�ӡ��(a, b) -> (a, d - 1)
 * �ұߵĴ�ӡ��(a, d) -> (c -1, d)
 * �±ߵĴ�ӡ��(c, d) -> (c, b+1)
 * ��ߵĴ�ӡ��(c, b) - > (a + 1, b)
 * @author zhx
 */
public class ˳ʱ���ӡ���� {

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
        ArrayList<Integer> list = ˳ʱ���ӡ����.printMatrix(matrix);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
