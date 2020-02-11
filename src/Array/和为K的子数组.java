package Array;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * @author zhx
 */
public class 和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(new Integer(0), 1);
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }
}
