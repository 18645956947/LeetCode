package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author zhx
 * 采用双指针方法，这道题还是不是很明白怎么做
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0;i < nums.length-2;i++){

            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){

                int l = i+1, r = nums.length-1,sum = 0-nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;

                    }else if(nums[l] + nums[r]  < sum){
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        l++;
                    }else{
                        while(l < r && nums[r] == nums[r - 1]){
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
