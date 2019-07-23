package Coding_Interviews;

import java.util.ArrayList;

/**
 * 剑指offer -- 和为S的两个数字
 * @author zhx
 */
public class 和为S的两个数字 {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length-1;
        ArrayList<Integer> res = new ArrayList();
        if(array.length == 0 || array == null){
            return res;
        }
        while(i < j){
            if(array[i] + array[j] == sum){
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
            else if(array[i] + array[j] < sum){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,8,9,14};
        System.out.println(和为S的两个数字.FindNumbersWithSum(a, 0));
    }
}
