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
}
