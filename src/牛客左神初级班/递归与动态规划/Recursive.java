package ţ�����������.�ݹ��붯̬�滮;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Recursive {
    /**
     * ����ʱһ��N��������
     * ������N�Ľ׳�
     * @return
     */
    public static long process_NFactorial(int n){
        if(n == 1){
            return 1L;
        }
        return (long) n * process_NFactorial(n - 1);
    }

    /**
     * ��ŵ������ ������Ҫ���� ʱ�临�Ӷ�O(2^N - 1)
     * @param N ���������ĸ���
     * @param from �ʼ������õĵط�
     * @param to Ŀ������
     * @param help ��������
     */
    public static void process_Hannota(int N, String from, String to, String help){
        if(N == 1){
            System.out.println(" move 1 from "+from+" to "+to);
            return;
        }else{
            process_Hannota(N - 1, from, help, to);
            System.out.println(" move "+ N + " from " + from +" to "+to);
            process_Hannota(N - 1, help, to, from);
        }
    }


    /**
     * ��һ���ַ��� ��ӡ���е�������
     * @param i ���ַ������ĸ�λ����
     * @param str ������ַ���
     * @param res ������ַ���
     */
    public static void process_Subsequences(char[] str, int i, String res){
        if(i == str.length){
            System.out.println(res);
            return;
        }
        process_Subsequences(str, i + 1, res);
        process_Subsequences(str, i + 1, res + String.valueOf(str[i]));
    }

    /**
     * ��1ֻĸţ��ÿ����һ����ÿ����ĸţ���µ�ĸţ�����Ҳ���ǵ�����Ҳ��ʼ�£����趼����������N���ĸţ������
     * @param N �����
     * @return ĸţ������
     */
    public static int process_Cows(int N){
        if(N < 1){
            return 0;
        }
        if(N == 1 || N == 2 || N == 3 || N == 4){
            return N;
        }
        return process_Cows(N - 1) + process_Cows(N - 3);
    }

    /**
     * ʵ��һ���ַ�����ȫ����
     * @param str �����ַ���
     * @param i ���Ǹ��ַ���
     */
    public static void process_Permutations(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process_Permutations(str , i + 1);
        }
    }

    public static void swap(char[] str, int i, int j){
        char tem = str[i];
        str[i] = str[j];
        str[j] = tem;
    }


    public static int minPath1(int[][] matrix, int i, int j){
        if(i == matrix.length - 1 && i == matrix[0].length - 1){
            return matrix[i][j];
        }
        if(i == matrix.length - 1){
            return matrix[i][j] + minPath1(matrix, i, j+1);
        }
        if(j == matrix[0].length - 1){
            return matrix[i][j] + minPath1(matrix, i + 1, j);
        }
        int right = minPath1(matrix, i, j+1);
        int down = minPath1(matrix, i+1, j);
        return matrix[i][j] + Math.min(right, down);
    }

    /**
     * ��ָOFFER - �ַ�����ȫ����
     * �������ظ��ַ�
     */
    public static class �ַ�����ȫ����{
        public ArrayList<String> Permutation(String str) {
            List<String> list = new ArrayList<>();
            if(str.length() == 0){
                return (ArrayList) list;
            }
            char[] chs = str.toCharArray();
            process(chs, 0, list);
            Collections.sort(list);
            return (ArrayList) list;
        }
        public void process(char[] chs, int i, List<String> list){
            if(i == chs.length - 1){
                if(!list.contains(new String(chs))){
                    list.add(new String(chs));
                }
            }else{
                for(int j = i; j < chs.length;j++){
                    swap(chs, i, j);
                    process(chs, i + 1, list);
                    swap(chs, i, j);
                }
            }
        }
        public void swap(char[] chs, int i, int j){
            if (i != j) {
                char t = chs[i];
                chs[i] = chs[j];
                chs[j] = t;
            }
        }
    }


    public static void main(String[] args) {

        Recursive.process_Hannota(3, "��", "��", "��");

        char[] str = new char[]{'a', 'b', 'c'};
        Recursive.process_Subsequences(str, 0, "");
        System.out.println(Recursive.process_Cows(5));
        System.out.println("====================");
        Recursive.process_Permutations(str, 0);
    }
}
