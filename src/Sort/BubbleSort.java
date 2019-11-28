package Sort;

import java.util.Arrays;

/**
 * @author zhx
 * @date 2019��3��14������10:32:58
 * ð������
 *
 */
public class BubbleSort {
	

	public static int[] bubble(int[] nums){
		if(nums == null || nums.length < 2){
			return nums;
		}
		for (int end = nums.length-1; end > 0; end--) {
			for (int j = 0; j < end; j++) {
				if(nums[j] > nums[j+1]){
					swap(nums, j, j+1);
				}
			}
		}
		return nums;
	}
	//����������
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	  //ð������
	 public static void main(String[] args) {
		 int[] sum = new int[] {4,3,3,2,1};
		 System.out.println(Arrays.toString(bubble(sum)));
	 }
	 
}
