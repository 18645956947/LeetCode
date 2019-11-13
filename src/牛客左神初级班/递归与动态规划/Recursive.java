package 牛客左神初级班.递归与动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Recursive {
    /**
     * 输入时一个N的正整数
     * 返回是N的阶乘
     * @return
     */
    public static long process_NFactorial(int n){
        if(n == 1){
            return 1L;
        }
        return (long) n * process_NFactorial(n - 1);
    }

    /**
     * 汉诺塔问题 返回需要几步 时间复杂度O(2^N - 1)
     * @param N 输入的砝码的个数
     * @param from 最开始砝码放置的地方
     * @param to 目标盘子
     * @param help 辅助盘子
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
     * 给一个字符串 打印所有的子序列
     * @param i 到字符串的哪个位置了
     * @param str 输入的字符串
     * @param res 输出的字符串
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
     * 有1只母牛，每年下一个，每次下母牛，新的母牛三年后，也就是第四年也开始下，假设都不会死，求N年后母牛的数量
     * @param N 求几年后
     * @return 母牛的数量
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
     * 实现一个字符串的全排列
     * @param str 给的字符串
     * @param i 到那个字符了
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
     * 剑指OFFER - 字符串的全排列
     * 考虑有重复字符
     */
    public static class 字符串的全排列{
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

        Recursive.process_Hannota(3, "左", "中", "右");

        char[] str = new char[]{'a', 'b', 'c'};
        Recursive.process_Subsequences(str, 0, "");
        System.out.println(Recursive.process_Cows(5));
        System.out.println("====================");
        Recursive.process_Permutations(str, 0);
    }
}
