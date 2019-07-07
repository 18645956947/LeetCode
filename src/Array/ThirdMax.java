package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 414. ���������
 * @author zhx
 */
public class ThirdMax {


    //��һ�ַ���  �����еļ���API����  ��ʱ182ms
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


    //ʱ��1ms�ڴ�38.2MB  ʱ�临�Ӷ�O(N) �ռ临�Ӷ�O(1)
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
