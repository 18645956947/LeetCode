package Array;


/** 
* @author ZHX
* @date 2019年3月15日下午1:32:14 
* @Description: 283. 移动零
 *
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾
 *  同时保持非零元素的相对顺序。
 * 维护一个INDEX 用来记录非零元素
*/
//283. 移动零
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int index = 0;
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		while(index<nums.length) {
			nums[index++]= 0; 
		}
	}
	public static void main(String[] args) {
		int[] num = new int[] {0,1,0,3,12};
		MoveZeroes d2 = new MoveZeroes();
		d2.moveZeroes(num);
	}
}
 