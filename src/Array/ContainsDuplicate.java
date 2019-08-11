package Array;

import java.util.HashSet;


/** 
* @author zhx
* @date 2019��3��15������1:47:08 
* @Description: 217. �����ظ�Ԫ��
* ��HashSet�ж������Ƿ��ظ�
*/
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> h1 = new HashSet<Integer>();
		for(int i = 0;i<nums.length;i++) {
			if(h1.contains(nums[i])) {
				return true;
			}
			else {
				h1.add(nums[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate s1 = new ContainsDuplicate();
		int[] num = new int[] {1,1,1,3,3,4,3,2,4,2};//true
		s1.containsDuplicate(num);
	}
}
 