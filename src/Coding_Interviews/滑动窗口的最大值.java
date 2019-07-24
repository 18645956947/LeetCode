package Coding_Interviews;

import java.util.ArrayList;

/**
 * ��ָoffer -- �������ڵ����ֵ
 * @author zhx
 */
public class �������ڵ����ֵ {

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || num.length < size || size < 0 || size == 0){
            return res;
        }
        if(size == 1){
            for (int i = 0; i < num.length;i++) {
                res.add(num[i]);
            }
            return res;
        }
        //[l ... r]
        int l = 0;
        int r = l+size-1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (r < num.length){
            int MAX = max(num[l], num[l+1], num[r]);
//            System.out.println(num[l] +"-----"+num[l+1] +"---"+num[r]);
            res.add(MAX);
            l++;
            r++;
        }
        return res;

    }
    private static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        System.out.println(�������ڵ����ֵ.maxInWindows(arr, 1));
    }
}
