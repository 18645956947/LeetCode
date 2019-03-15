package Array; 

/** 
* @author zhx
* @date 2019��3��15������2:04:06 
* @Description: 189. ��ת����
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
 