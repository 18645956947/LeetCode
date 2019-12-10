package Dynamic_Programming;

/**
 * leetcode - 152 乘积最大子序列
 * @author zhx
 *
 */
public class 乘积最大子序列 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length < 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0;i < nums.length;i++){

            if(nums[i] < 0){
                int tem = imax;
                imax = imin;
                imin = tem;
            }

            imax = Math.max(imax, imax * nums[i]);
            imin = Math.min(imin, imin * nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }
}
