package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * @author zhx
 */
public class FindDisappearedNumbers {

    //因为我们要的是【1....n】中没出现过的数字
    //假设有一个数组 a[1,5,4,2,1,4]    a[a[i]-1] 代表数组的第i个数出现过 出现过就把他变成负数，
    // 然后我们再遍历一遍数组中大于0的数字 下标加一就是我们消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }

}
