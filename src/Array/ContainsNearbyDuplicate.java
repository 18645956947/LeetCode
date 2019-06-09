package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * @author zhx
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // 两种方法 第一种map
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
        /** 第二种比较
         for(int i=0;i<nums.length;i++){
         for(int j=i+1;j<nums.length;j++){
         if(nums[i]==nums[j]&&j-i<=k){
         return true;
         }
         }
         }
         return false;
         **/
    }
}
