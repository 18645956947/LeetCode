package Sort;

import java.util.Arrays;

/**
 * @author lenovo
 * @date 2019年3月14日下午10:32:58
 * @Description:
 */
public class BubbleSort {
	
	//冒泡排序
	public static int[] bubble(int[] nums){
		int temp = 0;
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-i; j++) {
				if(nums[i] < nums[j]){
					swap(nums[i], nums[j]);
				}
			}
		}
		return nums;
	}
	//交换两个数
	public static void swap(int a, int b){
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}
	
	  //冒泡排序
	 public static void main(String[] args) {
		 int[] sum = new int[] {4,3,3,2,1};
		 System.out.println(Arrays.toString(bubble(sum)));
	 }
	 
}
