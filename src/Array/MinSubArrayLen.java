package Array;

/**
 * 209. 长度最小的子数组
 * @author zhx
 */
public class MinSubArrayLen {
    //滑动窗口概念
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;//nums[l...r] 维持的滑动窗口
        int res = nums.length+1;//结果存储

        int sum = 0;
        while( l < nums.length){
            if( r+1 < nums.length && sum < s){
                r++;
                sum += nums[r];
            }
            else{
                sum -= nums[l];
                l++;
            }
            if(sum >= s){
                res = Math.min(res, r-l+1);
            }
        }
        if(res == nums.length+1){
            return 0;
        }
        return res;

    }
}
