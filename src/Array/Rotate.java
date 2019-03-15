package Array; 

/** 
* @author zhx
* @date 2019年3月15日下午2:04:06 
* @Description: 189. 旋转数组
* 
*/
public class Rotate {
	public int[] rotate(int[] nums, int k) {
		int []result = new int[nums.length];
		for(int i = 0;i<nums.length;i++){
			result[(i+k)%nums.length] = nums[i];
		}
		return result;
	}
}
 