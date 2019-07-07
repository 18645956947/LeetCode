package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 414. 第三大的数
 * @author zhx
 */
public class ThirdMax {


    //第一种方法  用现有的集合API来做  用时182ms
    public int thirdMax_01(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            else
                list.add(nums[i]);
        }
        if(list.size() < 3){
            return list.get(list.size() - 1);
        }
        else{
            return list.get(list.size()-3);
        }
    }


    //时间1ms内存38.2MB  时间复杂度O(N) 空间复杂度O(1)
    public int thirdMax_02(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for(long num : nums){
            if(num > first){
                third = second;
                second = first;
                first = num;
            }
            else if(num > second && num < first){
                third = second;
                second = num;
            }
            else if(num > third && num < second){
                third = num;
            }
        }
        return third == Long.MIN_VALUE || third == second ? (int)first : (int)third;

    }

}
