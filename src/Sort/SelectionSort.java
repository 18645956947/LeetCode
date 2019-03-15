package Sort; 

/** 
* @author lenovo
* @date 2019��3��14������10:18:03 
* @Description: 
*/
public class SelectionSort {
	//ѡ������
	public static int[] selectionSort(int[] sum) {
		int minIndex,temp;
		for(int i = 0;i<sum.length-1;i++) {
			minIndex = i;
			for(int j = i+1;j<sum.length;j++) {
				if(sum[j] < sum[minIndex]) {
					minIndex = j;
				}
			}
			temp = sum[i];
			sum[i] = sum[minIndex];
			sum[minIndex] = temp;
		}
		return sum;
	}
	public static void main(String[] args) {
		//ѡ������
		int[] sum = new int[] {3,2,1,4};
		selectionSort(sum);
		for(int i = 0;i<sum.length;i++) {
			System.out.print(sum[i]);
		}
	}
	
		
}
 