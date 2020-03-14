package 剑指offer.数组;

import java.util.Arrays;

/**
 * 剑指offer - 数组中重复的数字
 * @author zhx
 */
public class 数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0 || numbers == null){
            return false;
        }
        //2 3 1 0 2 5 3
        //0 1 2 3 4 5 6
        //0 1 2 2 3 3 5
        Arrays.sort(numbers);
        int res = numbers[0];

        for(int i = 1; i< length;i++){
            if(res == numbers[i]){
                duplication[0] = numbers[i];
                return true;
            }
            res = numbers[i];
        }
        return false;
    }
}
