package Dynamic_Programming; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:39:02 
* @Description: 198. 打家劫舍
*/
public class Rob {
	public int rob(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		else if(nums.length == 1) {
			return nums[0];
		}
		else if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int result[] = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);
		
		for(int index= 2;index<nums.length;index++) {
			result[index] = Math.max(result[index-2] + nums[index], result[index-1]);
		}
		return result[nums.length-1];
	}
}
 