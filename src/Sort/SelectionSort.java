package Sort; 

/** 
* @author zhx
* @date 2019年3月14日下午10:18:03 
* @Description:
 * 选择排序
*/
public class SelectionSort {
	//选择排序
	public static int[] selectionSort(int[] sum) {
		if(sum == null || sum.length < 2){
			return sum;
		}
		for (int i = 0; i < sum.length - 1; i++) {
			int minIndex = i;

			for (int j = i+1; j < sum.length; j++) {
				minIndex = sum[j] < sum[minIndex] ? j : minIndex;
			}
			swap(sum, i, minIndex);
		}
		return sum;
	}
	private static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
		//选择排序
		int[] sum = new int[] {3,2,1,4};
		selectionSort(sum);
		for(int i = 0;i<sum.length;i++) {
			System.out.print(sum[i]);
		}
	}

}
 