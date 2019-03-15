package Array;


/** 
* @author ZHX
* @date 2019��3��15������1:32:14 
* @Description: 283. �ƶ���
 *
 *  ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ
 *  ͬʱ���ַ���Ԫ�ص����˳��
 * ά��һ��INDEX ������¼����Ԫ��
*/
//283. �ƶ���
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
 