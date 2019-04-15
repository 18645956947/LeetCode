package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 287. Ñ°ÕÒÖØ¸´Êı
 * @author zhx
 */
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        if(nums == null){
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsValue(nums[i])){
                return nums[i];
            }
            map.put(i, nums[i]);
        }
        return -1;
    }
    public static void main(String[] args){
        int[] a = new int[]{1,3,4,2,2};
        System.out.println(FindDuplicate.findDuplicate(a));

    }

}
