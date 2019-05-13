package Dynamic_Programming;

/**
 * 300. 最长上升子序列
 * @author zhx
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] memo = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            memo[i] = 1;
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    memo[i] = Math.max(memo[i], 1+memo[j]);
                }
            }
        }
        int res = 1;
        for(int i = 0;i<nums.length;i++){
            res = Math.max(res, memo[i]);
        }
        return res;

    }

}
