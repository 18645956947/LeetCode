package Dynamic_Programming; 

/** 
* @author ZHX
* @date 2019��3��15������2:36:38 
* @Description:53. �������� 
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
 