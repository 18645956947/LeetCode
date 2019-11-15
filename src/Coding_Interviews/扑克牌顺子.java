package Coding_Interviews;

import java.util.Arrays;

/**
 * 剑指offer - 扑克牌顺子
 * 1.排序
 * 2.统计0 的个数，
 * 3.统计相邻之间的差值是否可以由0的个数来补充
 * @author zhx
 */
public class 扑克牌顺子 {

    public boolean isContinuous(int [] numbers) {

        int len = numbers.length;
        //首先是判空操作
        if(len != 5 || numbers == null){
            return false;
        }
        int zero = 0;
        int num = 0;
        //先排个序
        Arrays.sort(numbers);
        for(int i = 0;i<len - 1;i++){
            //统计0的个数
            if(numbers[i] == 0){
                zero++;
                continue;
            }
            //碰到相同的直接返回false
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            //统计相邻的两个数的差值是否可以由0来填充
            num += numbers[i+1] - numbers[i] - 1;
        }
        //最后直接判断0的个数可以填充空闲的元素
        if(zero >= num){
            return true;
        }
        return false;
    }
}
