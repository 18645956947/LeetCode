package ţ�����������;

/**
 * ����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��, ��ͼ��˳ʱ����ת 90 �ȡ�
 *
 * ˵����
 * ������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 * @author zhx
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix){
        //��Ӧ���Ǿ�������Ͻǵı߽�(a, b)
        int a = 0;
        int b = 0;
        //��Ӧ���Ǿ�������½ǵı߽�(c, d)
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c){
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }
    public static void rotateEdge(int[][] m, int a, int b, int c, int d){
        int time = d - b;
        int temp = 0;
        for (int i = 0; i < time; i++) {
            temp = m[a][b+i];
            m[a][b + i] = m[c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}
