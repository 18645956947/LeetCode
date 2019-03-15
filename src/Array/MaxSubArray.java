package Array; 

/** 
* @author zhx
* @date 2019年3月15日下午1:59:55 
* @Description: 53. 最大子序和
* 
*/
public class MaxSubArray {
	 public int maxSubArray(int[] nums) {
			int n = nums[0];
			int sum = nums[0];
			for(int i = 1;i<nums.length;i++) {
				if(n > 0) {
					n += nums[i];
				}
				else {
					n = nums[i];
				}
				if(sum < n) {
					sum = n;
				}
			}
			return sum;
		}
}
 